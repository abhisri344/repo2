package com.nagarro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User is a model class used for storing Username and passwords of different
 * users in the database
 * 
 * @author abhisheksrivastava02
 *
 */
@Entity
@Table(name = "userDetailsTable")
public class User {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "userpassword")
	private String password;

	/**
	 * getter method for getting username of the user
	 * 
	 * @return username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter method for setting username of the user
	 * 
	 * @param username - username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter method for getting password of the user
	 * 
	 * @return password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter method for setting password of the user
	 * 
	 * @param password - password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Parameterized constructor for initializing instance variables
	 * 
	 * @param username - username to set
	 * @param password - password to set
	 */
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * toString method for printing User object
	 * 
	 * @return a string representing the User object
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	/**
	 * Non- Parameterized constructor for initializing instance variables
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

}
