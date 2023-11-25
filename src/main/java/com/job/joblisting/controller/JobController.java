package com.job.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.joblisting.dao.PostRepository;
import com.job.joblisting.dao.SearchRepository;
import com.job.joblisting.models.Post;
import com.mongodb.client.MongoClient;



@RestController
public class JobController {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	SearchRepository searchRepository;
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {

		return postRepository.findAll();

	}

	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {

		return postRepository.save(post);
	}

	@DeleteMapping("{id}")
	public void deletePost(@PathVariable String id) {

		postRepository.deleteById(id);
	}

	@GetMapping("post/{id}")
	public Post findById(@PathVariable String id) {

		return postRepository.findById(id).get();
	}

	@PostMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text) {

		return searchRepository.findbyText(text);

	}

}
