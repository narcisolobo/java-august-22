package com.nlobo.lakersroster.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlobo.lakersroster.models.Laker;
import com.nlobo.lakersroster.services.LakerService;

@RestController
public class LakerController {
	
	private final LakerService lakerService;
	
	public LakerController(LakerService lakerService) {
		this.lakerService = lakerService;
	}
	
	@GetMapping("/api/lakers")
	public List<Laker> findAllLakers() {
		return lakerService.allLakers();
	}

}
