package com.ticketbooking.dto;

public class CinemaSeatsDto {

	private Long id;

	private Long seatNo;

	private Long status;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the seatNo
	 */
	public Long getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(Long seatNo) {
		this.seatNo = seatNo;
	}

	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}
}
