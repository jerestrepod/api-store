package com.co.store.models.service;

import com.co.store.models.entity.User;

/**
 * 
 * @author  Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
public interface IUserService {

	/**
	 * bring user by name and is used for the login process
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * persist user entity
	 * @param user
	 * @return
	 */
	public User registerUser(User user);
}
