package com.nlobo.ownersandpets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlobo.ownersandpets.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
	List<Pet> findAll();

}
