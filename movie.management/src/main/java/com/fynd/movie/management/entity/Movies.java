package com.fynd.movie.management.entity;

import java.util.List;

public class Movies {
	private int id;
	private float popularity;
	private String director;
	private List<String> genre;


	private float imdb_score;
	private String name;

	public Movies() {

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImdb_score(float imdb_score) {
		this.imdb_score = imdb_score;
	}
	public float getPopularity() {
		return popularity;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public float getImdb_score() {
		return imdb_score;
	}

	public void setImdb_score(Float imdb_score) {
		this.imdb_score = imdb_score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
