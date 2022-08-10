package com.nlobo.lakersroster.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nlobo.lakersroster.models.Laker;
import com.nlobo.lakersroster.services.LakerService;

@RestController
public class LakerAPIController {
	
	private final LakerService lakerService;
	
	public LakerAPIController(LakerService lakerService) {
		this.lakerService = lakerService;
	}
	
	@GetMapping("/api/lakers")
	public List<Laker> findAllLakers() {
		return lakerService.allLakers();
	}
	
	@PostMapping("/api/lakers")
	public Laker createLaker(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("position") String position,
			@RequestParam("age") Integer age,
			@RequestParam("height") String height,
			@RequestParam("weight") Integer weight,
			@RequestParam("college") String college) {
		Laker laker = new Laker(firstName, lastName, position, age, height, weight, college);
		return lakerService.saveLaker(laker);
	}
	
	@GetMapping("/api/lakers/{id}")
	public Laker findOneLaker(@PathVariable("id") Long id) {
		return lakerService.findLaker(id);
	}
	
	@PutMapping("/api/lakers/{id}")
	public Laker updateLaker(
			@PathVariable("id") Long id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("position") String position,
			@RequestParam("age") Integer age,
			@RequestParam("height") String height,
			@RequestParam("weight") Integer weight,
			@RequestParam("college") String college) {
		Laker laker = lakerService.findLaker(id);
		laker.setFirstName(firstName);
		laker.setLastName(lastName);
		laker.setPosition(position);
		laker.setAge(age);
		laker.setHeight(height);
		laker.setWeight(weight);
		laker.setCollege(college);
		return lakerService.saveLaker(laker);
	}
	
	@DeleteMapping("/api/lakers/{id}")
	public void deleteLaker(@PathVariable("id") Long id) {
		Laker laker = lakerService.findLaker(id);
		lakerService.deleteLaker(laker);
	}

}
