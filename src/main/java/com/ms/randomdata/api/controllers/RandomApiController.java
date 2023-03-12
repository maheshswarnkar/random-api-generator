package com.ms.randomdata.api.controllers;

import java.net.MalformedURLException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.services.RootService;
import com.ms.randomdata.api.utils.UniqeNumberFromDateTime;

@RestController
@RequestMapping("api")
public class RandomApiController {

	@Autowired
	RootService rootService;

	Logger logger = LogManager.getLogger(RootService.class);

	@GetMapping("/save")
	public String saveRandomApiData() throws MalformedURLException {

		int numberOfRecords = 100;

		for (int i = 0; i < numberOfRecords; i++) {
			Root rootObj = rootService.callRandomApi();
			rootService.save(rootObj);

			System.out.println("Record is saved -- " + i + "th");
		}

		return (numberOfRecords + " Records are saved !!");
	}

	@GetMapping("/randomApi/{numberOfRecords}")
	public String createRandomApiData(@PathVariable("numberOfRecords") int numberOfRecords)
			throws MalformedURLException {

		long startTime = System.currentTimeMillis();
		logger.info("Call is started and UUID " + (UUID.randomUUID().toString()));

		for (int i = 1; i <= numberOfRecords; i++) {
			Root rootObj = rootService.callRandomApi();
			rootObj.setMsUniqueId(UniqeNumberFromDateTime.generateUniqueNumberFromTime());
			rootObj.setReqRecords(numberOfRecords);
			rootService.save(rootObj);

			System.out.println("Record is saved -- " + i + "th");
			logger.info("Record is saved -- " + i + "th" + "\n" + rootObj.getMsUniqueId());
		}

		long endTime = System.currentTimeMillis();
		return (numberOfRecords + " Records are saved and System took " + ((endTime - startTime) / 1000) + " minutes"
				+ " or " + ((endTime - startTime)) + " ms");
	}

}
