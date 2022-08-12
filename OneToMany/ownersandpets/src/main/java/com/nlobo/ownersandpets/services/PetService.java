package com.nlobo.ownersandpets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlobo.ownersandpets.models.Pet;
import com.nlobo.ownersandpets.repositories.PetRepository;

@Service
public class PetService {
	
	@Autowired
	PetRepository petRepository;
	
	public List<Pet> fetchAllPets() {
		return petRepository.findAll();
	}
	
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet fetchOnePet(Long id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		if (optionalPet.isEmpty()) return null;
		return optionalPet.get();
	}
	
	public void deletePet(Pet pet) {
		petRepository.delete(pet);
	}

}
