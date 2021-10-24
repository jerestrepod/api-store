package com.co.store.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.co.store.models.dao.IUserDAO;
import com.co.store.models.entity.User;
import com.co.store.models.service.IUserService;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Service
public class IUserServiceImpl implements IUserService{

	
	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}


	@Override
	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

}
