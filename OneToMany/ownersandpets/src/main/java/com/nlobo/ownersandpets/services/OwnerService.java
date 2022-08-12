package com.nlobo.ownersandpets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlobo.ownersandpets.models.Owner;
import com.nlobo.ownersandpets.repositories.OwnerRepository;

@Service
public class OwnerService {
	
	@Autowired
	OwnerRepository ownerRepository;
	
	// getting all owners
	public List<Owner> fetchAllOwners() {
		return ownerRepository.findAll();
	}
	
	// creating and updating an owner
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	// getting one owner
	public Owner fetchOneOwner(Long id) {
		Optional<Owner> optionalOwner = ownerRepository.findById(id);
		if (optionalOwner.isEmpty()) return null;
		return optionalOwner.get();
	}
	
	// deleting an owner
	public void deleteOwner(Owner owner) {
		ownerRepository.delete(owner);
	}

}
