package com.nlobo.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlobo.loginreg.models.LoginUser;
import com.nlobo.loginreg.models.User;
import com.nlobo.loginreg.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		// empty user object for register form
		model.addAttribute("user", new User());
		// empty loginuser object for login form
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/users/register")
	public String registerUser(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		
		// call register method in service
		User newUser = userService.register(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}

}
