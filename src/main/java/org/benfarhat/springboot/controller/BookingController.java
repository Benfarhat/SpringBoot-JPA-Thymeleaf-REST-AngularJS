package org.benfarhat.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.benfarhat.springboot.model.HotelBooking;
import org.benfarhat.springboot.repository.BookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
@Api(
		name="Hotel Booking API", 
		description = "Some restful method to manage hotel bookings", 
		stage = ApiStage.RC)
public class BookingController {

	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingController(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	public BookingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	// @GetMapping("/all") // Did'nt work with JSONDoc
	@ApiMethod(description = "Retrieve all hotel bookings from the database")
	public List<HotelBooking> getAll(){
		return bookingRepository.findAll();
	}	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	@ApiMethod(description = "Display a specific hotel booking containing request param provided")
	public List<HotelBooking> getHotelBooking(@ApiPathParam(name = "name") @RequestParam("name") String name){
		return bookingRepository.findByHotelNameContaining(name);
	}
	
	@RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
	@ApiMethod(description = "Get all hotel booking where the price is less than the provided value")
	public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price){
		/*
		return bookingRepository.findAll().stream()
				.filter(x -> x.getPricePerNight() <= price)
				.collect(Collectors.toList());	
		*/
		return bookingRepository.findByPricePerNightLessThanEqual(price);
	}
	
	@PostMapping("/create")
	@ApiMethod(description = "Create a hotel booking and save it to the database")
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
		bookingRepository.save(hotelBooking);
		return bookingRepository.findAll();
	}
	
	@PostMapping("/delete/{id}")
	@ApiMethod(description = "Remove the hotel booking with the provided ID, from the database")
	public List<HotelBooking> create(@ApiPathParam(name = "id") @PathVariable Long id){	
		if(bookingRepository.existsById(id))
			bookingRepository.deleteById(id);
		return bookingRepository.findAll();
	}
	
	
	
	
}
