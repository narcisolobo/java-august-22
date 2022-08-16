package com.nlobo.watchlist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlobo.watchlist.models.Movie;
import com.nlobo.watchlist.models.User;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	List<Movie> findAll();
	List<Movie> findByCreator(User creator);

}
