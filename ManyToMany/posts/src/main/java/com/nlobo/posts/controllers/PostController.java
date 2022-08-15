package com.nlobo.posts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nlobo.posts.models.Post;
import com.nlobo.posts.models.User;
import com.nlobo.posts.services.PostService;
import com.nlobo.posts.services.UserService;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/posts")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findById((Long) session.getAttribute("userId"));
		List<Post> posts = postService.fetchAllPosts();
		model.addAttribute("user", user);
		model.addAttribute("posts", posts);
		return "posts.jsp";
	}
	
	@GetMapping("/posts/new")
	public String newPost(
			HttpSession session,
			Model model,
			@ModelAttribute("post") Post post) {
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "newPost.jsp";
	}
	
	@PostMapping("/posts/insert")
	public String insertPost(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("post") Post post,
			BindingResult result) {
		if (result.hasErrors()) {
			User user = userService.findById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "newPost.jsp";
		}
		postService.savePost(post);
		return "redirect:/posts";
	}
	
	

}
