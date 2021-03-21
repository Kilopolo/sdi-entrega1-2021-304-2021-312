package com.uniovi.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Offer;
import com.uniovi.entities.User;
import com.uniovi.repositories.OffersRepository;

@Service
public class OfferService {

	@Autowired
	OffersRepository offersRepository;
	
	public Page<Offer> getOffers(Pageable p, User user){
		Page<Offer> offers = offersRepository.findAllforUser(p, user);
		return offers;
	}
	
	public List<Offer> getOffers(){
		List<Offer> offers = new ArrayList<Offer>();
		offersRepository.findAll().forEach(offers::add);;
		return offers;
	}
	
	public Page<Offer> getBoughtOffers(Pageable pageable,User owner){
		Page<Offer> boffers = new PageImpl<Offer>(new LinkedList<Offer>());
		boffers = offersRepository.findBoughtOffers(pageable, owner);
		return boffers;
	}
	
	public Offer getOffer(Long id) {
		return offersRepository.findById(id).get();
	}
	
	public void addOffer(Offer offer) {
		offersRepository.save(offer);
	}
	
	public void deleteOffer(Long id) {
		offersRepository.deleteById(id);
	}
	
	public void setOfferAvailable(boolean av, Long id) {
		offersRepository.updateAvailable(av, id);
	}
	
	public Page<Offer> searchOffersByTitle(Pageable p, String searchText){
		searchText = "%"+searchText+"%";
		Page<Offer> boffers = new PageImpl<Offer>(new LinkedList<Offer>());
		boffers = offersRepository.searchByTitle(p, searchText);
		return boffers;
	}

	public void editOffer(Offer offer) {
		offersRepository.save(offer);
		
	}

}
