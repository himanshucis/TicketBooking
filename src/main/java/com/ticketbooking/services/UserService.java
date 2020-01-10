package com.ticketbooking.services;

import com.ticketbooking.entity.User;

public interface UserService {

	/**
	 * method for user registration
	 * 
	 * @param user
	 * @return status of registration
	 */
	User registerUser(User user);

	/**
	 * method for user login
	 * 
	 * @param user
	 * @return user details like email , password
	 */
	User loginUser(User user);

	/**
	 * method for get user by id
	 * 
	 * @param id
	 * @return user by id
	 */
	User findById(Long id);

	/**
	 * method for get user by email
	 * 
	 * @param email
	 * @return user by email
	 */
	User findByEmail(String email);
}
