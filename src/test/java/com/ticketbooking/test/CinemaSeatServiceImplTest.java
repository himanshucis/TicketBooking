/**
 * 
 */
package com.ticketbooking.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

import com.ticketbooking.constant.SqlQueries;
import com.ticketbooking.entity.CinemaSeats;
import com.ticketbooking.entity.User;
import com.ticketbooking.repository.CinemaSeatRepository;
import com.ticketbooking.services.CinemaSeatService;

/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CinemaSeatServiceImplTest {

	private CinemaSeatRepository cinemaSeatRepository;

	@MockBean
	private Query query;

	@Autowired
	private CinemaSeatService cinemaService;

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
		cinemaSeatRepository = Mockito.mock(CinemaSeatRepository.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		when(query.executeUpdate()).thenReturn(2);
	}
	
	@Test
	public void testSaveSeat() {
		CinemaSeats seat = new CinemaSeats();
		User user = new User();
		user.setId(1l);
		user.setEmail("user@gmail.com");
		user.setAddress("indore");
		user.setMobile("8877664455");
		user.setPassword("user");
		user.setName("user");
		seat.setId(1l);
		seat.setSeatNo(1l);
		seat.setUser(user);
		seat.setStatus(1);
		when(cinemaSeatRepository.findBySeatNo(Mockito.anyLong())).thenReturn(seat);
		when(cinemaSeatRepository.save(Mockito.any(CinemaSeats.class))).thenReturn(seat);
		CinemaSeats saveSeats = cinemaService.saveSeat(seat);
		assertEquals(saveSeats.getId(), seat.getId());
	}

	@Test
	public void testGetAllSeats() {
		List<CinemaSeats> listSeats = new ArrayList<CinemaSeats>();
		CinemaSeats seat = new CinemaSeats();
		User bookUser = new User();
		bookUser.setId(1l);
		bookUser.setEmail("user@gmail.com");
		bookUser.setAddress("indore");
		bookUser.setMobile("8877664455");
		bookUser.setPassword("user");
		bookUser.setName("user");
		seat.setId(1l);
		seat.setSeatNo(1l);
		seat.setUser(bookUser);
		seat.setStatus(1);
		
		CinemaSeats seats = new CinemaSeats();
		seats.setStatus(1);
		seats.setId(2l);
		
		listSeats.add(seat);
		listSeats.add(seats);
		
		when(cinemaSeatRepository.findAll()).thenReturn(listSeats);
		List<CinemaSeats> fetchList = cinemaService.getSeats();
		
		assertEquals(listSeats.size(), fetchList.size());
		assertEquals(listSeats.get(0).getId(), fetchList.get(0).getId());
		
 	}

	@Test
	void testUpdateSeat() {
		CinemaSeats seat = new CinemaSeats();
		User bookUser = new User();
		bookUser.setId(1l);
		bookUser.setEmail("user@gmail.com");
		bookUser.setAddress("indore");
		bookUser.setMobile("8877664455");
		bookUser.setPassword("user");
		bookUser.setName("user");
		seat.setId(1l);
		seat.setSeatNo(1l);
		seat.setUser(bookUser);
		seat.setStatus(1);
		when(cinemaSeatRepository.findBySeatNo(Mockito.anyLong())).thenReturn((seat));
		CinemaSeats updateSeat = cinemaService.updateSeat(seat);
		assertEquals(updateSeat.getId(),seat.getId());
	}
	
}
