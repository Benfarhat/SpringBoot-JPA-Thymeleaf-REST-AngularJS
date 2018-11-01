package org.benfarhat.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.benfarhat.springboot.model.HotelBooking;
import org.benfarhat.springboot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	private BookingRepository bookingRepository;
	@Value("${app-mode}")
	private String appMode;
	@Value("${app-author}")
	private String appAuthor;
	@Autowired
	public ViewController(BookingRepository bookingRepository, Environment env) {
		super();
		this.bookingRepository = bookingRepository;
		// Next line is equivalet to using @value annotation
		// appMode = env.getProperty("app-mode");
	}

	public ViewController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("datetime", new Date());
		model.addAttribute("username", appAuthor);
		model.addAttribute("hotelBookings", bookingRepository.findAll());
		model.addAttribute("mode", appMode);

		return "index";
	}

}
