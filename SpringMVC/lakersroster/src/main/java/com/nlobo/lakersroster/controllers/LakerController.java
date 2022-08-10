package com.nlobo.lakersroster.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
