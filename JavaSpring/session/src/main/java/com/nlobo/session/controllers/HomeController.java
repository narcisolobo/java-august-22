package com.nlobo.session.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		System.out.println("Get attribute: " + session.getAttribute("username"));
		model.addAttribute("username", session.getAttribute("username"));
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String process(
			HttpSession session,
			@RequestParam("username") String username) {
		System.out.println("Username from form: " + username);
		session.setAttribute("username", username);
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
