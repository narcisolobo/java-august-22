package com.nlobo.watchlist.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
		List<Movie> usersMovies = movieService.fetchUsersMovies(user);
		model.addAttribute("user", user);
		model.addAttribute("movies", movies);
		model.addAttribute("usersMovies", usersMovies);
		return "movies.jsp";
	}
	
	// get route to new movie form
	@GetMapping("/movies/new")
	public String newMovie(
			Model model,
			HttpSession session,
			@ModelAttribute("movie") Movie movie) {
		// this protects the route from non-logged in users
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "newMovie.jsp";
	}
	
	// post route to add and validate new movie
	@PostMapping("/movies/insert")
	public String insertMovie(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("movie") Movie movie,
			BindingResult result) {
		if (result.hasErrors()) {
			User user = userService.findById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "newMovie.jsp";
		}
		System.out.println(movie.getCreator().getUsername());
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	// view one movie's details
	@GetMapping("/movies/{id}")
	public String showMovie(
			Model model,
			HttpSession session,
			@PathVariable("id") Long id) {
		// this protects the route from non-logged in users
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Movie movie = movieService.fetchOneMovie(id);
		User user = userService.findById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		model.addAttribute("movie", movie);
		return "showMovie.jsp";
	}
	
	// get route for edit form
	@GetMapping("/movies/{id}/edit")
	public String editMovie(
			Model model,
			HttpSession session,
			@PathVariable("id") Long id) {
		// this protects the route from non-logged in users
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findById((Long) session.getAttribute("userId"));
		Movie movie = movieService.fetchOneMovie(id);
		model.addAttribute("user", user);
		model.addAttribute("movie", movie);
		return "editMovie.jsp";
	}
	
	@PutMapping("/movies/{id}/update")
	public String updateMovie(
			Model model,
			HttpSession session,
			@Valid @ModelAttribute("movie") Movie movie,
			BindingResult result) {
		if (result.hasErrors()) {
			User user = userService.findById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "editMovie.jsp";
		}
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	@DeleteMapping("/movies/{id}/delete")
	public String deleteMovie(@PathVariable("id") Long id) {
		Movie movie = movieService.fetchOneMovie(id);
		movieService.deleteMovie(movie);
		return "redirect:/movies";
	}
}
