package com.fynd.movie.management.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fynd.movie.management.entity.MOVIE;
import com.fynd.movie.management.entity.Movies;
import com.fynd.movie.management.persistance.dao.MovieRepositoryDAO;
import com.fynd.movie.management.service.IMovieManager;

@Repository
public class MovieManagerImpl implements IMovieManager {

	private MovieRepositoryDAO movieRepositoryDao;

	@Autowired
	public MovieManagerImpl(MovieRepositoryDAO movieRepositoryDao) {
		this.movieRepositoryDao = movieRepositoryDao;
	}

	@Override
	public List<Movies> getMovies() {
		List<Movies> movie = processMoviesList(movieRepositoryDao.findAll());
		return movie;
	}

	private List<Movies> processMoviesList(List<MOVIE> movies) {
		List<Movies> movieList = new ArrayList<Movies>();
		for (MOVIE mov : movies) {
			Movies mov1 = new Movies();
			String[] elements = mov.getGenre().split(",");
			List<String> fixedLenghtList = Arrays.asList(elements);
			ArrayList<String> listOfGenres = new ArrayList<String>(fixedLenghtList);
			mov1.setGenre(listOfGenres);
			mov1.setDirector(mov.getDirector());
			mov1.setImdb_score(mov.getImdb_score());
			mov1.setName(mov.getName());
			mov1.setPopularity(mov.getPopularity());
			mov1.setId(mov.getId());
			movieList.add(mov1);
		}
		return movieList;
	}

	@Override
	public void addMovie(Movies movie) {
		MOVIE mov = processMovie(movie);
		movieRepositoryDao.persist(mov);

	}

	private MOVIE processMovie(Movies mov) {
		MOVIE mov1 = new MOVIE();
		List<String> genreList = mov.getGenre();
		String genres = String.join(",", genreList);
		mov1.setGenre(genres);
		mov1.setDirector(mov.getDirector());
		mov1.setImdb_score(mov.getImdb_score());
		mov1.setName(mov.getName());
		mov1.setId(mov.getId());
		mov1.setPopularity(mov.getPopularity());
		return mov1;
	}

	private Movies processMovies(MOVIE mov) {
		Movies mov1 = new Movies();
		String[] elements = mov.getGenre().split(",");
		List<String> fixedLenghtList = Arrays.asList(elements);
		ArrayList<String> listOfGenres = new ArrayList<String>(fixedLenghtList);
		mov1.setGenre(listOfGenres);
		mov1.setDirector(mov.getDirector());
		mov1.setImdb_score(mov.getImdb_score());
		mov1.setName(mov.getName());
		mov1.setPopularity(mov.getPopularity());
		mov1.setId(mov.getId());
		return mov1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void deleteMovie(String name, String director) {
		MOVIE mov1 = movieRepositoryDao.findById(getMovies().stream()
				.filter(movie -> (movie.getName().equals(name) && movie.getDirector().equals(director))).findFirst()
				.orElse(null).getId());
		movieRepositoryDao.delete(mov1);
	}

	@SuppressWarnings("unused")
	private Movies findByName(String name, String director) {
		MOVIE mov1 = movieRepositoryDao.findById(getMovies().stream()
				.filter(movie -> (movie.getName().equals(name) && movie.getDirector().equals(director))).findFirst()
				.orElse(null).getId());
		return processMovies(mov1);

	}

	@Override
	public void updateMovie(Movies movies) {
		MOVIE movie=processMovie(movies);
		movieRepositoryDao.update(movie);
	}

	@Override
	public void addMovies(List<Movies> movieList) {
		for (Movies movie : movieList) {
			MOVIE mov = processMovie(movie);
			movieRepositoryDao.persist(mov);
		}

	}


}
