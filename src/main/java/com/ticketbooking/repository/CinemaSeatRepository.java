package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entity.CinemaSeats;

@Repository
public interface CinemaSeatRepository extends JpaRepository<CinemaSeats, Long> {

	/**
	 * 
	 * @param id
	 * @return cinemaSeat by id
	 */
	public CinemaSeats findBySeatNo(Long id);
}
