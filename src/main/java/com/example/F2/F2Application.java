package com.example.F2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class F2Application {

	public static void main(String[] args) {
		SpringApplication.run(F2Application.class, args);
	}
	@Autowired
	private DataService dataService;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Insert data into the database
			dataService.insertData();
		};
	}
}
