package com.ticketbooking.services.impl;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.constant.Constant;
import com.ticketbooking.entity.User;
import com.ticketbooking.repository.UserRepository;
import com.ticketbooking.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	/**
	 * method implementation for user register
	 */
	@Override
	public User registerUser(User user) {
		User oldUser = userRepository.findByEmail(user.getEmail());
		if (oldUser == null) {
			user.setPassword(userRepository.encryptPassword(user.getPassword()));
			LOGGER.log(Level.INFO, "user registered successfully");
			return userRepository.save(user);
		} else {
			LOGGER.log(Level.INFO, "user registered failed :");
			return Constant.USERSTATUS;
		}
	}

	/**
	 * method implementation for login user
	 */
	@Override
	public User loginUser(User user) {
		// find user by email
		User oldUser = userRepository.findByEmail(user.getEmail());
		user.setPassword(userRepository.encryptPassword(user.getPassword()));
		if (oldUser.getPassword().equals(user.getPassword())) {
			LOGGER.log(Level.INFO, "user login successfully");
			return oldUser;
		} else {
			LOGGER.log(Level.INFO, "user login failed :");
			return Constant.USERSTATUS;
		}
	}

	/**
	 * method implementation for find user by id
	 */
	@Override
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.isPresent() ? user.get() : Constant.USERSTATUS;
	}

	/**
	 * method implementation for find use by email
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
