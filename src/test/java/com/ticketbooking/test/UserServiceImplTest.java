/**
 * 
 */
package com.ticketbooking.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketbooking.entity.User;
import com.ticketbooking.repository.UserRepository;
import com.ticketbooking.services.UserService;

/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {
	
	@MockBean 
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRegisterUser() {
		User user = new User();
		user.setId(1l);
		user.setEmail("user@gmail.com");
		user.setAddress("indore");
		user.setMobile("8877664455");
		user.setPassword("user");
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User userSaved = userService.registerUser(user);
		assertEquals(user.getId(), userSaved.getId());
	}
	
	@Test
	void testLoginUser(){
		User user = new User();
		user.setId(1l);
		user.setEmail("user@gmail.com");
		user.setAddress("indore");
		user.setMobile("8877664455");
		user.setPassword("user");
		when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		User loginUser = userService.findById(1l);
		assertEquals(loginUser.getEmail(), user.getEmail());
	}

	@Test
	void testGetByEmail() {
		User user = new User();
		user.setId(1l);
		user.setEmail("user@gmail.com");
		user.setAddress("indore");
		user.setMobile("8877664455");
		user.setPassword("user");
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(user);
		User userFetch = userService.findByEmail(user.getEmail());
		assertEquals(userFetch.getEmail(), user.getEmail());
	}
}
