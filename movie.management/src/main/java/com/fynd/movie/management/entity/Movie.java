package com.fynd.movie.management.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {



	@Id
	@GeneratedValue
	@Column(name="ID")
	private int Id;
	@Column(name = "POPULARITY")
	private float popularity;
	@Column(name = "DIRECTOR")
	private String director;
	@Column(name = "GENRE")
	private String genre;
	@Column(name = "IMDB_SCORE")
	private float imdb_score;
	@Column(name = "NAME")
	private String name;

	public Movie(){


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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getImdb_score() {
		return imdb_score;
	}

	public void setImdb_score(float imdb_score) {
		this.imdb_score = imdb_score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
