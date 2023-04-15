package com.ms.randomdata.api.controllers;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.randomdata.api.logs.ApiLogger;
import com.ms.randomdata.api.models.Employee;
import com.ms.randomdata.api.models.ResultList;
import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.services.ApiLogFileReaderService;
import com.ms.randomdata.api.services.RootService;
import com.ms.randomdata.api.utils.UniqeNumberFromDateTime;

@RestController
@RequestMapping("")
public class RandomApiController {

	@Autowired
	RootService rootService;

	@Autowired
	ApiLogFileReaderService apiLogFileReaderService;

	ApiLogger apiLogger;

	Logger logger = LogManager.getLogger(RootService.class);

	@GetMapping("/employees")
	public String getEmployeeData() {
		List<Employee> employeeData = rootService.getEmployeeData();
		StringBuilder builder = new StringBuilder();
		builder.append("\"employeesList\"{").append(employeeData.toString()).append("}");
		JSONParser parser = new JSONParser(builder.toString());
		System.out.println(employeeData.toString());
		return builder.toString();
	}

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

	@PostMapping("/randomApi/{numberOfRecords}")
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

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/randomApi")
	public ResultList getRandomApiData() throws MalformedURLException {

		long startTime = System.currentTimeMillis();
		logger.info("Call is started and UUID is : " + (UUID.randomUUID().toString()));

		List<Root> randomApiDataFromDB = rootService.getRandomApiFromDB();
		List<com.ms.randomdata.api.models.Result> listOfResults = new ArrayList<>();

		ResultList resultList = new ResultList();

		int loopCount = 0;
		for (Root root : randomApiDataFromDB) {
			logger.info("Result " + " loopCount " + loopCount + " " + root.getResult());
			com.ms.randomdata.api.models.Result result = root.getResult();
			listOfResults.add(result);
			loopCount++;
		}

		long endTime = System.currentTimeMillis();
		logger.info("Records got from DB " + randomApiDataFromDB.size() + " and System took "
				+ ((endTime - startTime) / 1000) + " minutes" + " or " + ((endTime - startTime)) + " ms");

		resultList.setResults(listOfResults);

		return (resultList);

	}

	@GetMapping("/readLogFile")
	public String getReadLogFile() {
		System.out.println("inside of readLogFile..");
		apiLogFileReaderService.readLogFile();

		return "Successfully read log file";
	}

}
