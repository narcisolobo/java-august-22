package com.nlobo.lakersroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nlobo.lakersroster.models.Laker;
import com.nlobo.lakersroster.services.LakerService;


@Controller
public class LakerController {

	private final LakerService lakerService;
	
	public LakerController(LakerService lakerService) {
		this.lakerService = lakerService;
	}
	
	@GetMapping("/lakers")
	public String getAllLakers(Model model) {
		List<Laker> allLakers = lakerService.allLakers();
		model.addAttribute("allLakers", allLakers);
		return "lakers.jsp";
	}
	
	@GetMapping("/lakers/{id}")
	public String getOneLaker(
			Model model,
			@PathVariable("id") Long id) {
		Laker laker = lakerService.findLaker(id);
		model.addAttribute("laker", laker);
		return "showLaker.jsp";
	}
	
	@GetMapping("/lakers/new")
	public String getNewLakerForm(@ModelAttribute("laker") Laker laker) {
		return "newLaker.jsp";
	}
	
	@PostMapping("/lakers/insert")
	public String insertLaker(
			@Valid @ModelAttribute("laker") Laker laker,
			BindingResult result) {
		if (result.hasErrors()) return "newLaker.jsp";
		lakerService.saveLaker(laker);
		return "redirect:/lakers";
	}
	
	@GetMapping("/lakers/{id}/edit")
	public String getEditLakerForm(
			@PathVariable("id") Long id,
			Model model) {
		Laker laker = lakerService.findLaker(id);
		model.addAttribute("laker", laker);
		return "editLaker.jsp";
	}
	
	@PutMapping("/lakers/{id}/update")
	public String updateLaker(
			@Valid @ModelAttribute("laker") Laker laker,
			BindingResult result) {
		if (result.hasErrors()) return "editLaker.jsp";
		lakerService.saveLaker(laker);
		return "redirect:/lakers";
	}
	
	@DeleteMapping("/lakers/{id}/delete")
	public String deleteLaker(@PathVariable("id") Long id) {
		Laker laker = lakerService.findLaker(id);
		lakerService.deleteLaker(laker);
		return "redirect:/lakers";
	}
}
