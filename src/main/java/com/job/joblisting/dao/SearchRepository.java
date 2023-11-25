package com.job.joblisting.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.job.joblisting.models.Post;

@Repository
public interface SearchRepository{

	List<Post> findbyText(String text);

}
