package com.job.joblisting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.joblisting.dao.PostRepository;
import com.job.joblisting.models.Post;

@Service
public class PostService {

	@Autowired
	PostRepository repository;

	public List<Post> getPostsByExperience(int experience) {
		// TODO Auto-generated method stub

		List<Post> allPosts = repository.findAll();
		List<Post> ePosts = new ArrayList<>();

		for (Post post : allPosts) {
			if (post.getExperience() >= experience) {
				ePosts.add(post);
			}
		}

		return ePosts;

	}

	public Post updatePostByDescription(String id, String description) {
		// TODO Auto-generated method stub

		// System.out.println(repository.);
		Post post = repository.findById(id).get();

		post.setDescription(description);

		repository.save(post);

		return post;

	}

	public Post updatePostByExperience(String id, int experience) {
		// TODO Auto-generated method stub
		Post post = repository.findById(id).get();

		post.setExperience(experience);

		repository.save(post);

		return post;
	}

}
