package com.nlobo.movies.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	/*
	 * RESTful Routing
	 * api/movies
	 * 
	 * GET:
	 * api/movies - all movies
	 * api/movies/{id} - one movie by id
	 * 
	 * POST:
	 * api/movies - create movie
	 * 
	 * PUT:
	 * api/movies/{id}
	 * 
	 * DELETE:
	 * api/movies/{id}
	 * 
	 * 
	 * api/characters
	 * api/directors
	 * 
	 */
	
	@GetMapping("")
	public String getAllMovies() {
		return "In the getAllMovies method.";
	}
	
	@GetMapping("/query")
	public String queryAllMovies(@RequestParam(value="q") String query) {
		return "You are searching for: " + query;
	}
	
	@GetMapping("/{id}")
	public String getMovieById(@PathVariable("id") String id) {
		return "You have found movie with ID: " + id;
	}

}
