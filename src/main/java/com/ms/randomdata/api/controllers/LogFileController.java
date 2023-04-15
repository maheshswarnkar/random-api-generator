package com.ms.randomdata.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.randomdata.api.models.ApiLogs;
import com.ms.randomdata.api.services.ApiLogFileReaderService;

@RestController
@RequestMapping("api")
public class LogFileController {
	
	@Autowired
	ApiLogFileReaderService apiLogFileReaderService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/logs")
	public List<ApiLogs> getLogFileData() {
		System.out.println("inside of getLogFileData..");
		return apiLogFileReaderService.getLogs();
	}

}
