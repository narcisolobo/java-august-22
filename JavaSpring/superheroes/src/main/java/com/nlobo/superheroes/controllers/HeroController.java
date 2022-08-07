package com.nlobo.superheroes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nlobo.superheroes.models.Hero;

@Controller
public class HeroController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/heroes";
	}
	
	// This was supposed to be a list of superheroes, but
	// I got sidetracked. Let's call it colors instead.
	@GetMapping("/colors")
	public String colors(Model model) {
		ArrayList<String> colorStrings = new ArrayList<String>();
		colorStrings.add("Red");
		colorStrings.add("Blue");
		colorStrings.add("Yellow");
		colorStrings.add("Green");
		System.out.println("In the heroes route");
		model.addAttribute("bananas", colorStrings);
		return "colors.jsp";
	}
	
	// Let's see what the heroes route was supposed to be
	@GetMapping("/heroes")
	public String heroes(Model model) {
		List<Hero> heroes = new ArrayList<Hero>();
		heroes.add(new Hero("Spider-Man", "Peter Parker"));
		heroes.add(new Hero("Shang-Chi", "Zheng Shang-Chi"));
		heroes.add(new Hero("Echo", "Maya Lopez"));
		heroes.add(new Hero("Iron Man", "Tony Stark"));
		heroes.add(new Hero("Captain Marvel", "Carol Danvers"));
		heroes.add(new Hero("Black Panther", "T'Challa"));
		heroes.add(new Hero("Black Widow", "Natasha Romanov"));
		model.addAttribute("heroes", heroes);
		return "heroes.jsp";
	}
}
