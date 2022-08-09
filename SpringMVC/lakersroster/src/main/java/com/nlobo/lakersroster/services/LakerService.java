package com.nlobo.lakersroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nlobo.lakersroster.models.Laker;
import com.nlobo.lakersroster.repositories.LakerRepository;

@Service
public class LakerService {
	
	private final LakerRepository lakerRepository;
	
	public LakerService(LakerRepository lakerRepository) {
		this.lakerRepository = lakerRepository;
	}
	
    // returns all the Lakers
    public List<Laker> allLakers() {
        return lakerRepository.findAll();
    }
    
    // creates a Laker
    public Laker createLaker(Laker laker) {
    	return lakerRepository.save(laker);
    }
    
    // retrieves a Laker
    public Laker findLaker(Long id) {
        Optional<Laker> optionalLaker = lakerRepository.findById(id);
        
        if(optionalLaker.isPresent()) {
            return optionalLaker.get();
        } else {
            return null;
        }
    }

}
