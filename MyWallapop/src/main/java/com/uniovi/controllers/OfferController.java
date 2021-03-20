package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Offer;
import com.uniovi.services.OfferService;
import com.uniovi.services.UsersService;

@Controller
public class OfferController {

	@Autowired
	OfferService offersService;
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/offer/list")
	public String getList(Model model){
		model.addAttribute("offerList", offersService.getOffers());
		return "offer/list";
	}
	
	
	@RequestMapping(value = "/offer/add")
	public String getOffer(Model model){
		model.addAttribute("userList", usersService.getUsers());
		return "offer/add";
	}
	
	@RequestMapping(value = "/offer/add", method = RequestMethod.POST)
	public String setOffer(@ModelAttribute Offer offer){
		offersService.addOffer(offer);
		return "redirect:/offer/list";
	}
	
	@RequestMapping(value = "/offer/delete/{id}")
	public String deleteOffer(@PathVariable Long id){
		offersService.deleteOffer(id);
		return "redirect:/offer/list";
	}
}
