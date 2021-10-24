package com.co.store.models.service;

import com.co.store.models.entity.User;

/**
 * 
 * @author  Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
public interface IUserService {

	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * @param user
	 * @return
	 */
	public User registerUser(User user);
}
