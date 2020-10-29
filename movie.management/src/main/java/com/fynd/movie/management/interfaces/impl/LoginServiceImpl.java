package com.fynd.movie.management.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fynd.movie.management.interfaces.ILoginService;
import com.fynd.movie.management.interfaces.IMovieManager;

@Component
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private IMovieManager movieManager;

	@Override
	public boolean authenticate(String userId,String password) {
		return movieManager.authenticate(userId, password);


	}

}
