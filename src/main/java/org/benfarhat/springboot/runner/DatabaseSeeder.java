package org.benfarhat.springboot.runner;

import java.util.ArrayList;
import java.util.List;

import org.benfarhat.springboot.model.HotelBooking;
import org.benfarhat.springboot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{
	private BookingRepository bookingRepository;
	
	@Autowired
	public DatabaseSeeder(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}


	@Override
	public void run(String... args) throws Exception {

		List<HotelBooking> bookings = new ArrayList<>();
		bookings.add(new HotelBooking("Marina", 200.50, 3));
		bookings.add(new HotelBooking("Antlantic", 90, 8));
		bookings.add(new HotelBooking("Grandiose", 75.8, 5));
		bookings.add(new HotelBooking("Scarlet", 143.9, 3));
		bookings.add(new HotelBooking("Diamond", 64.4, 6));
		bookings.add(new HotelBooking("OcenSide", 147.2, 2));
		bookings.add(new HotelBooking("Fantasy", 205.8, 2));
		bookings.add(new HotelBooking("Triumph", 55.7, 6));
		bookings.add(new HotelBooking("Regal", 301.9, 1));

		
		bookingRepository.saveAll(bookings);
	}
	

}

