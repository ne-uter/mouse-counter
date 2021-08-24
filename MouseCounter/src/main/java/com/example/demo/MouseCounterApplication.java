package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MouseCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MouseCounterApplication.class, args);
	}

}
