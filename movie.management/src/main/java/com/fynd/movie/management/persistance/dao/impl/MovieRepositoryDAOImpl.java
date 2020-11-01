package com.fynd.movie.management.persistance.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fynd.movie.management.entity.MOVIE;
import com.fynd.movie.management.persistance.dao.MovieRepositoryDAO;

@Repository
public class MovieRepositoryDAOImpl implements MovieRepositoryDAO {

	@Autowired
	private SessionManager sessionMangager;

	public MovieRepositoryDAOImpl(SessionManager sessionMangager) {
		this.sessionMangager = sessionMangager;
	}

	public Session getCurrentSession() {
		return sessionMangager.getCurrentSession();
	}

	public void persist(MOVIE entity) {
		sessionMangager.openCurrentSessionwithTransaction();
        getCurrentSession().save(entity);
        sessionMangager.closeCurrentSessionwithTransaction();

	}

	public void update(MOVIE entity) {
		sessionMangager.openCurrentSessionwithTransaction();
		getCurrentSession().update(entity);
		sessionMangager.closeCurrentSessionwithTransaction();
	}

	public MOVIE findById(int id) {
		sessionMangager.openCurrentSessionwithTransaction();
		MOVIE movie =  getCurrentSession().get(MOVIE.class, id);
		sessionMangager.closeCurrentSessionwithTransaction();
		return movie;
	}

	public void delete(MOVIE entity) {
		sessionMangager.openCurrentSessionwithTransaction();
		getCurrentSession().delete(entity);
		sessionMangager.closeCurrentSessionwithTransaction();
	}

	@SuppressWarnings("unchecked")
	public List<MOVIE> findAll() {
		sessionMangager.openCurrentSessionwithTransaction();
		List<MOVIE> movies = (List<MOVIE>) getCurrentSession().createQuery("from MOVIE",MOVIE.class).list();
		sessionMangager.closeCurrentSessionwithTransaction();
		return movies;
	}

	public void deleteAll() {
		List<MOVIE> entityList = findAll();
		for (MOVIE entity : entityList) {
			delete(entity);
		}
	}

}
