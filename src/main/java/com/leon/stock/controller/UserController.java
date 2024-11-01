package com.leon.stock.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leon.stock.model.User;
import com.leon.stock.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping("/login")
//	public Principal user(Principal user) {
//		return 	user;
//	}
//	
	
	@PostMapping("/api/auth/login")
	public Optional<User>  login(@RequestBody User user) {

		System.out.println(user.getEmail());
		return userService.login(user.getEmail(), user.getPassword());
	}
	
}
