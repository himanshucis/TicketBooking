package com.ticketbooking.constant;

import com.ticketbooking.entity.CinemaSeats;
import com.ticketbooking.entity.User;

public class Constant {

	public static final int STATUS = 1;
	public static final int UPDATESTATUS = 0;
	public static final User USER = null;
	public static final User USERSTATUS = null;
	public static final CinemaSeats SEATSTATUS = null;
	public static final String INDEX = "index";
	public static final String HOME ="home";
	public static final String BOOKING = "booking";
	public static final String  USERDETAILS = "userdetails";
	public static final String REGISTRATION = "registration";
	public static final String LOGIN = "login";
	public static final String REGISTRATION_ERROR = "regerror";
	public static final String LOGIN_ERROR = "loginerror";
	public static final String SUCCESS = "success";
	public static final String ERROR ="error";
	public static final String LOGIN_REDIRECT = "redirect:/usercontroller/login";
	public static final String BOOKING_REDIRECT = "redirect:/bookingcontroller/booking";
	public static final String HOME_REDIRECT = "redirect:/bookingcontroller/home";
	public static final String LOGINERROR_REDIRECT = "redirect:/usercontroller/loginerror";
	public static final String HOMEPAGE_REDIRECT = "redirect:/homecontroller/home";
}
