package com.ticketbooking.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ticketbooking.dto.UserDto;
import com.ticketbooking.entity.User;

@Component
public class UserMapper {

	/**
	 * Dto to entity mapper
	 * @param userdto
	 * @return user
	 */
	public User dtoToEntity(UserDto userdto) {
		User user = new User();
		if (userdto != null) {
			BeanUtils.copyProperties(userdto, user);
		}
		return user;
	}

	/**
	 * entity to Dto mapper
	 * @param user
	 * @return userdto
	 */
	public UserDto EntityToDto(User user) {
		UserDto userdto = new UserDto();
		if (user != null) {
			BeanUtils.copyProperties(user, userdto);
		}
		return userdto;
	}
}
