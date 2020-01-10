package com.ticketbooking.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ticketbooking.constant.Constant;
import com.ticketbooking.entity.CinemaSeats;
import com.ticketbooking.repository.CinemaSeatRepository;
import com.ticketbooking.services.CinemaSeatService;

@Service
public class CinemaSeatServiceImpl implements CinemaSeatService {

	@Autowired
	private CinemaSeatRepository cinemaSeatsRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	private static final Logger LOGGER = Logger.getLogger(CinemaSeatServiceImpl.class.getName());

	/**
	 * method implementation for Get All Cinema Seats
	 */
	@Override
	public List<CinemaSeats> getSeats() {
		return cinemaSeatsRepository.findAll();
	}

	/**
	 * mathod implementation for Save cinema Seat for particular User
	 */
	@Override
	public CinemaSeats saveSeat(CinemaSeats seats) {
		CinemaSeats seat = cinemaSeatsRepository.findBySeatNo(seats.getSeatNo());
		if (seat != null) {
			seat.setStatus(Constant.STATUS);
			seat.setUser(seats.getUser());
			// book seat for ticket
			seat = cinemaSeatsRepository.save(seat);
			if (seat != null) {
				LOGGER.log(Level.INFO, "seat successfully book by user and send conformation email");
				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo(seat.getUser().getEmail());
				msg.setSubject("Cinema Ticket Booking");
				msg.setText("Dear sir/ma'am\n" + seat.getUser().getName() + "\nYour Cinema Seat No. " + seat.getSeatNo()
						+ " Booked Successfully.\n");
				javaMailSender.send(msg);
				return seat;
			}
			return Constant.SEATSTATUS;
		}
		return Constant.SEATSTATUS;
	}

	/**
	 * method implementation for update cinema-seat details
	 */
	@Override
	public CinemaSeats updateSeat(CinemaSeats seats) {
		CinemaSeats oldSeat = cinemaSeatsRepository.findBySeatNo(seats.getSeatNo());
		if (oldSeat.getUser().getId() == seats.getUser().getId()) {
			LOGGER.log(Level.INFO, "seat details successfully updated : ");
			oldSeat.setStatus(Constant.UPDATESTATUS);
			oldSeat.setUser(Constant.USER);
			cinemaSeatsRepository.save(oldSeat);
			return oldSeat;
		} else {
			return Constant.SEATSTATUS;
		}
	}

	/**
	 * method implementation for get seat by particular number
	 */
	@Override
	public CinemaSeats findBySeatNo(Long id) {
		return cinemaSeatsRepository.findBySeatNo(id);
	}
}
