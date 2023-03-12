package com.ms.randomdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ms.randomdata.api.services.RootService;

@SpringBootApplication
public class RandomDataApiGeneratorApplication {

	@Autowired
	RootService rootService;

	public static void main(String[] args) {
		SpringApplication.run(RandomDataApiGeneratorApplication.class, args);
		System.out.println("Application is started..");
	}

}
