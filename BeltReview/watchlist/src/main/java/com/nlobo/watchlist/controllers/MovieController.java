package com.nlobo.watchlist.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nlobo.watchlist.models.Movie;
import com.nlobo.watchlist.models.User;
import com.nlobo.watchlist.services.MovieService;
import com.nlobo.watchlist.services.UserService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	UserService userService;
	
	// dashboard showing all movies
	@GetMapping("/movies")
	public String movies(HttpSession session, Model model) {
		// this protects the route from non-logged in users
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User user = userService.findById((Long) session.getAttribute("userId"));
		List<Movie> movies = movieService.fetchAllMovies();
		model.addAttribute("user", user);
		model.addAttribute("movies", movies);
		return "movies.jsp";
	}
	
	// get route to new movie form
	@GetMapping("/movies/new")
	public String newMovie(
			Model model,
			HttpSession session,
			@ModelAttribute("movie") Movie movie) {
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "newMovie.jsp";
	}
}
