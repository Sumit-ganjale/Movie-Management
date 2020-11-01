package com.fynd.movie.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fynd.movie.management.entity.UserMaster;
import com.fynd.movie.management.persistance.dao.UserRepositoryDAO;
import com.fynd.movie.management.service.ILoginService;

@Component
public class LoginServiceImpl implements ILoginService {

	private UserRepositoryDAO repositoryDAO;

	@Autowired
	public LoginServiceImpl(UserRepositoryDAO movieManager) {
		super();
		this.repositoryDAO = movieManager;
	}

	@Override
	public boolean authenticate(String userId, String password) {
		List<UserMaster> userList = repositoryDAO.findAll();
		for (UserMaster user : userList) {
			return user.getPassword().equals(userId) && user.getPassword().equals(password);
		}
		return false;

	}

}
