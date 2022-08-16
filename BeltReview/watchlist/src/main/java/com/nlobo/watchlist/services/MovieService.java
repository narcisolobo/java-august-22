package com.nlobo.watchlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlobo.watchlist.models.Movie;
import com.nlobo.watchlist.models.User;
import com.nlobo.watchlist.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	// Get all movies
	public List<Movie> fetchAllMovies() {
		return movieRepository.findAll();
	}
	
	// Get one user's movies
	public List<Movie> fetchUsersMovies(User creator) {
		return movieRepository.findByCreator(creator);
	}
	
	// Get one movie
	public Movie fetchOneMovie(Long id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		if (optionalMovie.isEmpty()) return null;
		return optionalMovie.get();
	}
	
	// Save movie (update/create)
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	// Delete movie
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

}
