package com.otbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otbs.model.MovieBooking;
import com.otbs.repository.MovieBookingRepo;

@RestController
@CrossOrigin("http://localhost:8080")
public class MovieBookingController {
	
	@Autowired
	private MovieBookingRepo mbr;
	@PostMapping("/movie")
	MovieBooking addUser(@RequestBody MovieBooking newBooking) {
		return mbr.save(newBooking);
	}
}
