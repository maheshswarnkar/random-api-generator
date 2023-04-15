package com.ms.randomdata.api.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.randomdata.api.converter.RequestToModelConverter;
import com.ms.randomdata.api.models.Employee;
import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.repository.ResultRepository;
import com.ms.randomdata.api.request.objects.Result;

@Service
public class RootService {

	Logger logger = LogManager.getLogger(RootService.class);

	@Autowired
	ResultRepository resultRepository;

	public void save(Root root) {
		resultRepository.save(root);
	}

	public static <T> T getJsonObjectMapper(URL url, Class<T> type) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(url, type);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public Root callRandomApi() throws MalformedURLException {
		String stringURI = "https://randomuser.me/api/";
		URL url = new URL(stringURI);
		Result resultPojo = getJsonObjectMapper(url, Result.class);
		System.out.println("Print result " + resultPojo);

		RequestToModelConverter requestToModelObjectConverter = new RequestToModelConverter();
		Root root = requestToModelObjectConverter.requestToModelObjectConverter(resultPojo);

//		System.out.println("Root \n" + root);

		return root;

	}
	
	public List<Root> getRandomApiFromDB() throws MalformedURLException {
		List<Root> rootList = resultRepository.findAll();

//		System.out.println("Root \n" + root);

		return rootList;

	}


	public List<Employee> getEmployeeData() {
		
		Employee emp1 = new Employee(101, "Mahesh", "IT");
		Employee emp2 = new Employee(102, "Naresh", "HR");
		Employee emp3 = new Employee(103, "Pankaj", "IT-DB");
		Employee emp4 = new Employee(104, "Gaurav", "IT");

		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(emp1);
		employeesList.add(emp2);
		employeesList.add(emp3);
		employeesList.add(emp4);

		return employeesList;
	}

}
