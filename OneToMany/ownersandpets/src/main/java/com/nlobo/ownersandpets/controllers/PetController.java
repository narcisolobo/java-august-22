package com.nlobo.ownersandpets.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlobo.ownersandpets.models.Pet;
import com.nlobo.ownersandpets.services.OwnerService;
import com.nlobo.ownersandpets.services.PetService;

@Controller
public class PetController {
	
	@Autowired
	PetService petService;
	
	@Autowired
	OwnerService ownerService;
	
	@GetMapping("/pets")
	public String getPets(
			Model model,
			@ModelAttribute("pet") Pet pet) {
		model.addAttribute("allPets", petService.fetchAllPets());
		model.addAttribute("allOwners", ownerService.fetchAllOwners());
		return "pets.jsp";
	}
	
	@PostMapping("/pets/insert")
	public String insertPet(
			Model model,
			@Valid @ModelAttribute("pet") Pet pet,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("allPets", petService.fetchAllPets());
			model.addAttribute("allOwners", ownerService.fetchAllOwners());
			return "pets.jsp";
		}
		petService.savePet(pet);
		return "redirect:/pets";
	}

}
