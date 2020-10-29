package com.fynd.movie.management.interfaces;

import java.util.List;

import com.fynd.movie.management.entity.Movie;
import com.fynd.movie.management.entity.Movies;

public interface IMovieManager {

	public List<Movies> getMovies();

	public void addMovie(Movies movie);

	public void deleteMovie(String name, String director);

	public void updateMovie(Movies movie);


	boolean authenticate(String userId, String password);

	public void addMovies(List<Movies> movie);
}
