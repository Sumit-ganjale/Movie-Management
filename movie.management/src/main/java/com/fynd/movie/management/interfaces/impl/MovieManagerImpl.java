package com.fynd.movie.management.interfaces.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fynd.movie.management.entity.Movie;
import com.fynd.movie.management.entity.Movies;
import com.fynd.movie.management.entity.USER_MASTER;
import com.fynd.movie.management.interfaces.IMovieManager;

@Repository
public class MovieManagerImpl implements IMovieManager {
	private EntityManager entityManager;

	@Autowired
	public MovieManagerImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean authenticate(String userId, String password) {
		boolean isAdmin = false;
		if (userId != null && password != null) {
			Session currentSession = entityManager.unwrap(Session.class);
			String query = "select DISPLAY_USER_ID from USER_MASTER where DISPLAY_USER_ID=:userid and USER_PASSWORD=:password";
			Query<USER_MASTER> theQuery = currentSession.createQuery(query);
			theQuery.setParameter("userid", userId);
			theQuery.setParameter("password", password);
			List<USER_MASTER> users = theQuery.list();
			if (!users.isEmpty()) {
				isAdmin = true;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	@Transactional
	public List<Movies> getMovies() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Movie> theQuery = currentSession.createQuery("from Movie", Movie.class);
		List<Movie> movies = theQuery.getResultList();
		List<Movies> movie = processMovies(movies);

		return movie;
	}

	private List<Movies> processMovies(List<Movie> movies) {
		List<Movies> movieList = new ArrayList<Movies>();
		for (Movie mov : movies) {
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
	@Transactional
	public void addMovie(Movies movie) {
		Movie mov = processMovies(movie);
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(mov);

	}

	private Movie processMovies(Movies mov) {
		Movie mov1 = new Movie();
		List<String> genreList = mov.getGenre();
		String genres=String.join(",", genreList);
		mov1.setGenre(genres);
		mov1.setDirector(mov.getDirector());
		mov1.setImdb_score(mov.getImdb_score());
		mov1.setName(mov.getName());
		mov1.setId(mov.getId());
		mov1.setPopularity(mov.getPopularity());
		return mov1;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteMovie(String name, String director) {
		Session currentSession = entityManager.unwrap(Session.class);
		String query = "delete from Movie where NAME=:name and DIRECTOR=:director";
		Query<USER_MASTER> theQuery = currentSession.createQuery(query);
		theQuery.setParameter("name", name);
		theQuery.setParameter("director", director);
		theQuery.executeUpdate();
	}

	@SuppressWarnings("unused")
	private Movies findByName(String name, String director) {
		return getMovies().stream()
				.filter(movie -> (movie.getName().equals(name) && movie.getDirector().equals(director))).findFirst()
				.orElse(null);
	}

	@Override
	@Transactional
	public void updateMovie(Movies movie) {
		Movie mov = processMovies(movie);
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.update(mov);

	}

	@Override
	@Transactional
	public void addMovies(List<Movies> movieList) {

		Session currentSession = entityManager.unwrap(Session.class);
		for (Movies movie : movieList) {
			Movie mov = processMovies(movie);
			currentSession.saveOrUpdate(mov);
		}

	}

}
