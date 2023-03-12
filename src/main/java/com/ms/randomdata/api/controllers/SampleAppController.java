package com.ms.randomdata.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SampleAppController {

	@GetMapping(value = "aws")
	public String welcomeAWSMessage() {
		return "Hello Mahesh. You are in AWS Application!!";
	}

}
