package com.job.joblisting.models;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JobPost")
public class Post {

	private String id;
	private String profile;
	private String description;
	private int experience;
	private String technologies[];
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post() {

	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", profile=" + profile + ", description=" + description + ", experience=" + experience
				+ ", technologies=" + Arrays.toString(technologies) + "]";
	}

	public Post(String id, String profile, String description, int experience, String[] technologies) {
		super();
		this.id = id;
		this.profile = profile;
		this.description = description;
		this.experience = experience;
		this.technologies = technologies;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String[] getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}

}
