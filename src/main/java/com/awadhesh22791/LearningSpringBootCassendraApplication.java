package com.awadhesh22791;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableWebFlux
@Slf4j
public class LearningSpringBootCassendraApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootCassendraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Initializing...");
	}

}
