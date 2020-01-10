package com.ticketbooking.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.constant.Constant;
import com.ticketbooking.dto.UserDto;
import com.ticketbooking.entity.User;
import com.ticketbooking.mapper.UserMapper;
import com.ticketbooking.services.UserService;

@Controller
@RequestMapping("/usercontroller")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	/**
	 * request for user registration page
	 * 
	 * @return registration page
	 */
	@GetMapping("/registration")
	public String registration() {
		return Constant.REGISTRATION;
	}

	/**
	 * request for User Registration
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * @param mobile
	 * @param address
	 * @return login page
	 */
	@PostMapping("/register")
	public String registerUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("mobile") String mobile,
			@RequestParam("address") String address) {
		UserDto userDto = new UserDto();
		userDto.setName(name);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setMobile(mobile);
		userDto.setAddress(address);
		User user = userMapper.dtoToEntity(userDto);
		// user details save or register
		user = userService.registerUser(user);
		if (user != null) {
			LOGGER.info("User registered successfully : ");
			return Constant.LOGIN;
		}
		return Constant.REGISTRATION_ERROR;
	}

	/**
	 * request for login
	 * 
	 * @return login page
	 */
	@GetMapping("/login")
	public String loginPage() {
		return Constant.LOGIN;
	}

	/**
	 * request for user Login
	 * 
	 * @param email
	 * @param password
	 * @param session
	 * @return home page
	 */
	@PostMapping("/loginuser")
	public ModelAndView loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		UserDto userDto = new UserDto();
		userDto.setEmail(email);
		userDto.setPassword(password);
		User user = userMapper.dtoToEntity(userDto);
		User newuser = userService.loginUser(user);
		if (newuser != null) {
			newuser = userService.findByEmail(user.getEmail());
			session.setAttribute("user", newuser.getId());
			LOGGER.info("User Login successfully : ");
			return new ModelAndView(Constant.HOME_REDIRECT);
		}
		return new ModelAndView(Constant.LOGINERROR_REDIRECT);
	}

	/**
	 * request for error page
	 * 
	 * @return error page
	 */
	@GetMapping("/loginerror")
	public String loginError() {
		return Constant.LOGIN_ERROR;
	}

	/**
	 * request for User logout
	 * 
	 * @param session
	 * @return homepage
	 */
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		if (session != null) {
			session.removeAttribute("user");
			LOGGER.info("User Logout successfully : ");
			return new ModelAndView(Constant.HOMEPAGE_REDIRECT);
		} else {
			return new ModelAndView(Constant.HOMEPAGE_REDIRECT);
		}
	}
}
