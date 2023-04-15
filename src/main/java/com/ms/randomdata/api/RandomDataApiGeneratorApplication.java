package com.ms.randomdata.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.randomdata.api.services.ApiLogFileReaderService;
import com.ms.randomdata.api.services.RootService;

@SpringBootApplication
@RestController
public class RandomDataApiGeneratorApplication {

	@Autowired
	RootService rootService;

	@GetMapping("/")
	public String mainPage() {
		return "RandomDataApiGeneratorApplication context page is called !!";
	}

	public static void main(String[] args) {
		SpringApplication.run(RandomDataApiGeneratorApplication.class, args);
		System.out.println("Application is started..");
	}

}
