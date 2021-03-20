package com.uniovi.repositories;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uniovi.entities.Offer;

public interface OffersRepository extends CrudRepository<Offer, Long>{
	
	@Modifying
	@Transactional
	@Query("UPDATE Offer SET available = ?1 WHERE id = ?2")
	void updateAvailable(Boolean av, Long id);

}
