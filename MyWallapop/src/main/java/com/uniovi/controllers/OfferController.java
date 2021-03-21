package com.uniovi.controllers;


import java.util.Date;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Offer;
import com.uniovi.entities.User;
import com.uniovi.services.OfferService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.AddOfferFormValidator;

@Controller
public class OfferController {

	@Autowired
	OfferService offersService;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	AddOfferFormValidator aofv;
	
	@Autowired
	private HttpSession httpSession;
	
	private boolean enough = true;
	
	
	@RequestMapping("/offer/list")
	public String getList(Pageable p, Model model, @RequestParam(value="", required=false) String searchText){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		Page<Offer> boffers = new PageImpl<Offer>(new LinkedList<Offer>());
		if(searchText != null && !searchText.isEmpty()) {
			boffers= offersService.searchOffersByTitle(p, searchText);
		}
		else {
			boffers=  offersService.getOffers(p, activeUser);
		}
		model.addAttribute("offerList",boffers.getContent());
		model.addAttribute("page", boffers);
		
		if(!enough)
			activeUser.setEnoughMoney(false);
		httpSession.setAttribute("activeUser",activeUser);
		return "offer/list";
	}
	
	@RequestMapping("/offer/ownList")
	public String getOwnList(Model model){
		model.addAttribute("offerList", offersService.getOffers());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		httpSession.setAttribute("activeUser",activeUser);
		return "offer/ownList";
	}
	
	@RequestMapping("/offer/buyView")
	public String getBuyViewList(Model model, Pageable p){
		Page<Offer> boffers = new PageImpl<Offer>(new LinkedList<Offer>());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		boffers =  offersService.getBoughtOffers(p , activeUser);
		
		httpSession.setAttribute("activeUser",activeUser);
		
		model.addAttribute("offerList", boffers.getContent());
		model.addAttribute("page",boffers);
		return "offer/buyView";
	}
	
	
	@RequestMapping(value = "/offer/add")
	public String getOffer(Model model){
		model.addAttribute("userList", usersService.getUsers());
		model.addAttribute("offer",new Offer());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		httpSession.setAttribute("activeUser",activeUser);
		return "offer/add";
	}
	
	
	@RequestMapping(value = "/offer/add", method = RequestMethod.POST)
	public String setOffer(Model model, @Validated Offer offer, BindingResult result){
		aofv.validate(offer, result);
		if(result.hasErrors()) {
			model.addAttribute("userList", usersService.getUsers());
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String email = auth.getName();
			User activeUser = usersService.getUserByEmail(email);
			httpSession.setAttribute("activeUser",activeUser);
			return "/offer/add";
		}
		offer.setOrderDate(new Date());
		offer.setAvailable(true);
		offersService.addOffer(offer);
		return "redirect:/offer/ownList";
	}
	
	@RequestMapping(value = "/offer/delete/{id}")
	public String deleteOffer(@PathVariable Long id){
		offersService.deleteOffer(id);
		return "redirect:/offer/ownList";
	}
	

	
	@RequestMapping(value = "/offer/{id}/available")
	public String setAvailableTrue(Model model, @PathVariable Long id){
		Offer offer = offersService.getOffer(id);
		Double m = offer.getAmount();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		Double money = activeUser.getMoney();
		if(money >= m) {
			this.enough= true;
			offersService.setOfferAvailable(false, id);
			activeUser.setMoney(money-m);
			usersService.editUser(activeUser);
			offer.setNewOwner(activeUser);
			offer.setAvailable(false);
			offersService.editOffer(offer);
			httpSession.setAttribute("activeUser",activeUser);
		}
		else {
			this.enough = false;
			
		}
		return "redirect:/offer/list";
	}
	
	@RequestMapping(value = "/offer/{id}/notAvailable")
	public String setAvailableFalse(Model model, @PathVariable Long id){
		this.enough =true;
		Offer offer = offersService.getOffer(id);
		Double m = offer.getAmount();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		Double money = activeUser.getMoney();
		offersService.setOfferAvailable(true, id);
		activeUser.setMoney(money+m);
		activeUser.setEnoughMoney(true);
		offer.setAvailable(true);
		offer.setNewOwner(null);
		activeUser.getBoughtOffers().remove(offer);
		usersService.editUser(activeUser);
		offersService.editOffer(offer);
		httpSession.setAttribute("activeUser",activeUser);
		return "redirect:/offer/buyView";
	}
	
}

