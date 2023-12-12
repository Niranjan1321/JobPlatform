package com.job.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.joblisting.dao.PostRepository;
import com.job.joblisting.dao.SearchRepository;
import com.job.joblisting.models.Post;
import com.job.joblisting.service.PostService;
import com.mongodb.client.MongoClient;

@RestController
public class JobController {

	@Autowired
	PostRepository postRepository;

	@Autowired
	SearchRepository searchRepository;

	@Autowired
	PostService service;

	@GetMapping("post/{id}")
	public Post findById(@PathVariable String id) {

		return postRepository.findById(id).get();
	}

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

	@GetMapping("/posts/experience/{experience}")
	public List<Post> getPostsByExperience(@PathVariable int experience) {

		return service.getPostsByExperience(experience);
	}

	@PostMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text) {

		return searchRepository.findbyText(text);

	}
	
	@PatchMapping("/{id}/description/{description}")
	public ResponseEntity<Post> updatePostByDescription(@PathVariable String id, @PathVariable String description){
		
		try {
			return new ResponseEntity<>(service.updatePostByDescription(id, description), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new Post(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/{id}/experience/{experience}")
	public ResponseEntity<Post> updatePostByExperience(@PathVariable String id, @PathVariable int experience){
		
		try {
			return new ResponseEntity<>(service.updatePostByExperience(id, experience), HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(new Post(), HttpStatus.NOT_FOUND);
		}
	}

}
