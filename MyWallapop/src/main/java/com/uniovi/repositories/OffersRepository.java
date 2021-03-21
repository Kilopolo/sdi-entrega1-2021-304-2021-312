package com.uniovi.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uniovi.entities.Offer;
import com.uniovi.entities.User;

public interface OffersRepository extends CrudRepository<Offer, Long>{
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Offer SET available = ?1 WHERE id = ?2")
	void updateAvailable(Boolean av, Long id);
	
	@Query("Select o FROM Offer o WHERE o.title = ?1")
	List<Offer> searchByTitle(String searchText);
	
	@Query("Select o From Offer o where o.newOwner!= null and o.newOwner = ?1")
	List<Offer> findBoughtOffers(User owner);

}
