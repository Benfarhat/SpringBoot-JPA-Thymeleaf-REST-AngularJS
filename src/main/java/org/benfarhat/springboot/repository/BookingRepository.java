package org.benfarhat.springboot.repository;

import java.util.List;

import org.benfarhat.springboot.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long>{

	// @see: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	List<HotelBooking> findByPricePerNightLessThan(double price);
	List<HotelBooking> findByPricePerNightLessThanEqual(double price);
	List<HotelBooking> findByHotelNameContaining(String hotelName);

}