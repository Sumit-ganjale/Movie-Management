package com.fynd.movie.management.persistance.dao;

import java.util.List;

import com.fynd.movie.management.entity.MOVIE;

public interface MovieRepositoryDAO {


		public List<MOVIE> findAll();

		public MOVIE findById(int id);

		public void delete(MOVIE movies);

		public void update(MOVIE movie);

		public void persist(MOVIE movie);

		public void deleteAll();
	}

