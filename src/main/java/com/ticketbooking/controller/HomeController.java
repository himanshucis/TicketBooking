package com.ticketbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketbooking.constant.Constant;

@Controller
@RequestMapping("/homecontroller")
public class HomeController {

	/**
	 * request for index page
	 * @return index page
	 */
	@GetMapping("/home")
	public String homePage() {
		return Constant.INDEX;
	}
}
