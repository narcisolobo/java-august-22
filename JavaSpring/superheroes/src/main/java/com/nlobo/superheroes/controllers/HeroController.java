package com.nlobo.superheroes.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeroController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/heroes";
	}
	
	@GetMapping("/heroes")
	public String heroes(Model model) {
		ArrayList<String> colorStrings = new ArrayList<String>();
		colorStrings.add("Red");
		colorStrings.add("Blue");
		colorStrings.add("Yellow");
		colorStrings.add("Green");
		System.out.println("In the heroes route");
		model.addAttribute("bananas", colorStrings);
		return "heroes.jsp";
	}
}
