package com.leon.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leon.stock.model.User;
import com.leon.stock.repository.UserRepository;

import lombok.Data;

@Service
@Data
public class UserService {

	@Autowired
	UserRepository userRepository;

//	public Optional<User> login(User user) {
//
//		return userRepository.findById(user.getId());
//	}
//	
	@Autowired
	private PasswordEncoder passwordEncoder; 

	public Optional<User> login(String username, String password) {
		User user = userRepository.findByEmail(username);
		if (user != null /* && passwordEncoder.matches(password, user.getPassword()) */) {
			return Optional.of(user);
		}
		return Optional.empty();
	}
}
