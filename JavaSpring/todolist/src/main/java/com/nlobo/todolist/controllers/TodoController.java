package com.nlobo.todolist.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nlobo.todolist.models.Todo;

@Controller
public class TodoController {
	
	@GetMapping("/todos")
	public String todos(
			Model model,
			HttpSession session) {
		if (session.getAttribute("todos") == null) {
			session.setAttribute("todos", new ArrayList<Todo>());
		}
		model.addAttribute("todos", session.getAttribute("todos"));
		model.addAttribute("username", session.getAttribute("username"));
		return "todos.jsp";
	}
	
	@PostMapping("/todos/name")
	public String createName(
			HttpSession session,
			// @RequestParam pulls info from form
			@RequestParam("username") String username) {
		session.setAttribute("username", username);
		return "redirect:/todos";
	}
	
	@PostMapping("/todos/insert")
	public String insertTodo(
			HttpSession session,
			// pull value from the form
			@RequestParam("description") String description) {
		
		// create a new Todo object
		Todo todo = new Todo(description);
		// add it to a Todo list
		// grab list from session
		@SuppressWarnings("unchecked")
		List<Todo> todos = (ArrayList<Todo>) session.getAttribute("todos");
		todos.add(todo);
		// put that list in session
		session.setAttribute("todos", todos);
		return "redirect:/todos";
	}

}
