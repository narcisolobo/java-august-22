package com.nlobo.posts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlobo.posts.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
	List<Post> findAll();

}
