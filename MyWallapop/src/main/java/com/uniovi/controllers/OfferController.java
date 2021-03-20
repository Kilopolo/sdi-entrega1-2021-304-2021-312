package com.uniovi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Offer;
import com.uniovi.entities.User;
import com.uniovi.services.OfferService;
import com.uniovi.services.UsersService;

@Controller
public class OfferController {

	@Autowired
	OfferService offersService;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	private HttpSession httpSession;
	
	private boolean enough = true;
	
	
	@RequestMapping("/offer/list")
	public String getList(Model model){
		model.addAttribute("offerList", offersService.getOffers());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
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
	
	
	@RequestMapping(value = "/offer/add")
	public String getOffer(Model model){
		model.addAttribute("userList", usersService.getUsers());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User activeUser = usersService.getUserByEmail(email);
		httpSession.setAttribute("activeUser",activeUser);
		return "offer/add";
	}
	
	@RequestMapping(value = "/offer/add", method = RequestMethod.POST)
	public String setOffer(@ModelAttribute Offer offer){
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
		usersService.editUser(activeUser);
		httpSession.setAttribute("activeUser",activeUser);
		return "redirect:/offer/list";
	}
	
}

