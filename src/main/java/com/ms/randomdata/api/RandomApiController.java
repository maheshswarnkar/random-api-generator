package com.ms.randomdata.api;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.services.RootService;

@RestController
@RequestMapping("api")
public class RandomApiController {

	@Autowired
	RootService rootService;

	@GetMapping("/save")
	public String saveRandomApiData() throws MalformedURLException {

		for (int i = 0; i < 100; i++) {
			Root rootObj = rootService.callRandomApi();
			rootService.save(rootObj);

			System.out.println("Record is saved -- " + i + "th");
		}

		return "Record is saved !!";
	}

}
