package com.otbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otbs.model.User;
import com.otbs.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User addUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@PostMapping("/login")
	User loginUser(@RequestBody User login) {
		String response="";
		User user= userRepository.findByEmail(login.getEmail());
		if(user!=null) {
			if(user.getPassword().equals(login.getPassword())) {
				return user;
			}
			else {
				response="Password is incorrect";
			}
		}
		else {
			response="Invalid user.!";
		}
		return null;
		
	}
	@GetMapping("users")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
