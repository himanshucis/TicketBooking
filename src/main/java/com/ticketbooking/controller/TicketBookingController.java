package com.ticketbooking.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ticketbooking.constant.Constant;
import com.ticketbooking.dto.UserDto;
import com.ticketbooking.entity.CinemaSeats;
import com.ticketbooking.entity.User;
import com.ticketbooking.mapper.UserMapper;
import com.ticketbooking.services.CinemaSeatService;
import com.ticketbooking.services.UserService;

@Controller
@RequestMapping("/bookingcontroller")
public class TicketBookingController {

	@Autowired
	private CinemaSeatService cinemaSeatService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = Logger.getLogger(TicketBookingController.class.getName());

	/**
	 * request for user login then home page Load
	 * 
	 * @param sesion
	 * @param model
	 * @return home page and login
	 */
	@GetMapping("/home")
	public ModelAndView homePage(HttpSession sesion, Model model) {
		Object user = sesion.getAttribute("user");
		if (user.equals(null)) {
			return new ModelAndView(Constant.LOGIN_REDIRECT);
		} else {
			model.addAttribute("user", user);
			return new ModelAndView(Constant.HOME);
		}
	}

	/**
	 * request for show cinema seat booking page
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/booking")
	public String bookingPage(HttpSession session, Model model) {
		// get cinema seatlists
		List<CinemaSeats> seatList = cinemaSeatService.getSeats();
		Object user = session.getAttribute("user");
		if (seatList != null && user != null) {
			LOGGER.info(seatList + "seatList get successfully : ");
			model.addAttribute("user", user);
			model.addAttribute("seats", seatList);
			return Constant.BOOKING;
		} else {
			return Constant.HOMEPAGE_REDIRECT;
		}

	}

	/**
	 * request for get user and seat deatails
	 * 
	 * @param seat
	 * @param session
	 * @param model
	 * @return userdetails page
	 */
	@GetMapping("/bookseat")
	public String bookSeat(@RequestParam("seat") Long seat, HttpSession session, Model model) {
		// get user in session
		Object user = session.getAttribute("user");
		model.addAttribute("user", user);
		model.addAttribute("seat", seat);
		return Constant.USERDETAILS;
	}

	/**
	 * request for book seat by user
	 * 
	 * @param name
	 * @param email
	 * @param mobile
	 * @param seatno
	 * @return success and error
	 */
	@PostMapping("/bookingseat")
	public String bookingSeat(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("seat") Long seatno, HttpSession session) {
		UserDto userDto = new UserDto();
		CinemaSeats seats = new CinemaSeats();
		Object id = session.getAttribute("user");
		userDto.setName(name);
		userDto.setEmail(email);
		userDto.setMobile(mobile);
		// Mapper for DTO to entity
		User user = userMapper.dtoToEntity(userDto);
		// find user by session id or login id
		User sessionUser = userService.findById((Long) id);
		// find user by email
		User oldUser = userService.findByEmail(user.getEmail());
		// check session user and details of email user same or not
		if (oldUser.getEmail().equals(sessionUser.getEmail())) {
			LOGGER.info("seat booking successfully : ");
			seats.setUser(oldUser);
			seats.setSeatNo(seatno);
			seats = cinemaSeatService.saveSeat(seats);
			if (seats != null) {
				return Constant.SUCCESS;
			}
			return Constant.ERROR;
		}
		return Constant.ERROR;
	}

	/**
	 * request for cancel seat by user
	 * 
	 * @param seatno
	 * @param session
	 * @return booking page
	 */
	@GetMapping("/cancelbooking")
	public ModelAndView cancelBooking(@RequestParam("seat") Long seatno, Model model, HttpSession session) {
		Object user = session.getAttribute("user");
		// get user by session id
		User oldUser = userService.findById((Long) user);
		CinemaSeats seats = new CinemaSeats();
		seats.setSeatNo(seatno);
		seats.setUser(oldUser);
		// update seat details by login user
		seats = cinemaSeatService.updateSeat(seats);
		if (seats != null) {
			LOGGER.info(seats + "seat update successfully : ");
			return new ModelAndView(Constant.BOOKING_REDIRECT);
		}
		model.addAttribute("seatstatus", seats);
		return new ModelAndView(Constant.BOOKING_REDIRECT);
	}
}
