package com.fynd.movie.management.persistance.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fynd.movie.management.entity.UserMaster;
import com.fynd.movie.management.persistance.dao.UserRepositoryDAO;

@Repository
public class UserRepositoryDAOImpl implements UserRepositoryDAO {

	@Autowired
	private SessionManager sessionMangager;

	public UserRepositoryDAOImpl(SessionManager sessionMangager) {
		this.sessionMangager = sessionMangager;
	}

	 public Session getCurrentSession() {
	        return sessionMangager.getCurrentSession();
	    }
	@Override
	public List<UserMaster> findAll() {
		List<UserMaster> userList = getCurrentSession().createQuery("from Movie").list();
		return userList;
	}
}
