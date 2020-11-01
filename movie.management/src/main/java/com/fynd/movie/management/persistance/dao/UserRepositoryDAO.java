package com.fynd.movie.management.persistance.dao;

import java.util.List;

import com.fynd.movie.management.entity.UserMaster;


public interface UserRepositoryDAO {

	public List<UserMaster> findAll();

	}


