package com.ticketbooking;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticketbooking.constant.SqlQueries;
import com.ticketbooking.repository.CinemaSeatRepository;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private CinemaSeatRepository cinemaSeatRepository;

	private static final Logger LOGGER = Logger.getLogger(TicketBookingApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// inserting data in seat table if table is empty

		if (cinemaSeatRepository.count() == 0) {
			LOGGER.info("Inserting data in seats table...");
			Query query = entityManager.createNativeQuery(SqlQueries.INSERT_DATA_IN_SEATS);
			System.out.println("=====>>"+query);
			query.executeUpdate();
			LOGGER.info("Data inseted in seats table successfully...");
		} else {
			LOGGER.info("Data alrady exist in seats table...");
		}

	}
}
