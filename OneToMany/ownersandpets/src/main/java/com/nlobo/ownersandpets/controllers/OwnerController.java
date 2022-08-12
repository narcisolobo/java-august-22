package com.nlobo.ownersandpets.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlobo.ownersandpets.models.Owner;
import com.nlobo.ownersandpets.services.OwnerService;

@Controller
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	@GetMapping("/owners")
	public String getOwners(
			Model model,
			@ModelAttribute("owner") Owner owner) {
		model.addAttribute("allOwners", ownerService.fetchAllOwners());
		return "owners.jsp";
	}
	
	@PostMapping("/owners/insert")
	public String insertOwner(
			Model model,
			@Valid @ModelAttribute("owner") Owner owner,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("allOwners", ownerService.fetchAllOwners());
			return "owners.jsp";
		}
		
		ownerService.saveOwner(owner);
		return "redirect:/owners";
	}
	
	@GetMapping("/owners/{id}")
	public String showOwner(
			Model model,
			@PathVariable("id") Long id) {
		model.addAttribute("owner", ownerService.fetchOneOwner(id));
		return "showOwner.jsp";
	}

}
