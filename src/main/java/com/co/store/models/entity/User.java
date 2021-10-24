package com.co.store.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an user.
 * 
 * @author Jhonatan Esteban Restrepo Duque.
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * serialVersionUID default
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * represent user id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	/**
	 * represent user email
	 */
	String email;
	/**
	 * represent user name
	 */
	String username;
	/**
	 * represent user password
	 */
	String password;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param userName the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}
