package com.leon.stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StockManagerApplication /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println((new BCryptPasswordEncoder()).encode("password"));
//		
//	}

}
