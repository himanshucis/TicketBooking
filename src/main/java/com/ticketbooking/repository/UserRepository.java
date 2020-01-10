package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 
	 * @param email
	 * @return user by email id
	 */
	User findByEmail(String email);

	/**
	 * method for password encryption
	 * 
	 * @param password
	 * @return encryptPassword
	 */
	@Query(value = "Select MD5(MD5(:password))", nativeQuery = true)
	public String encryptPassword(@Param(value = "password") String password);
}
