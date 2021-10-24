
package com.co.store.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.store.models.entity.User;

/**
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
public interface IUserDAO extends JpaRepository<User, Long>{
	
	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	
}
