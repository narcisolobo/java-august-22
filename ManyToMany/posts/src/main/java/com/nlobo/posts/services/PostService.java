package com.nlobo.posts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlobo.posts.models.Post;
import com.nlobo.posts.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public List<Post> fetchAllPosts() {
		return postRepository.findAll();
	}
	
	public Post savePost(Post post) {
		return postRepository.save(post);
	}
	
	public Post fetchOnePost(Long id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isEmpty()) return null;
		return optionalPost.get();
	}
	
	public void deletePost(Post post) {
		postRepository.delete(post);
	}

}
