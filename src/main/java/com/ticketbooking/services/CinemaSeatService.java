package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.entity.CinemaSeats;

public interface CinemaSeatService {

	/**
	 * save seat by particular user
	 * @param seats
	 * @return seat status seat book or not
	 */
	 CinemaSeats saveSeat (CinemaSeats seats);
	 
	 /**
	  * get all seats of cinema
	  * @return List of Cinema seats
	  */
	 List<CinemaSeats> getSeats();
	 
	 /**
	  * update seat details for cancel booking
	  * @param seats
	  * @return update status of seat status
	  */
	 CinemaSeats updateSeat (CinemaSeats seats);
	 
	 /**
	  * method for get seat by number
	  * @param id
	  * @return seat object by number
	  */
	 CinemaSeats findBySeatNo(Long id);
}
