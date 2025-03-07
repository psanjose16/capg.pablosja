package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoBoot01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoBoot01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("Application launched");
	}

    @Bean
    CommandLineRunner demo() {
		return (args) -> {
			System.err.println("Application laaaaaunched");
		};
	}
	
}
