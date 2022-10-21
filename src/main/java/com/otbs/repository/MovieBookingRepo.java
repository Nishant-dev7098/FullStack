package com.otbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otbs.model.MovieBooking;
import com.otbs.model.User;

public interface MovieBookingRepo extends JpaRepository<MovieBooking,Long>{
	MovieBooking findByEmail(String email);
}
