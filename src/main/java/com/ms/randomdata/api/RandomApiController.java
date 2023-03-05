package com.ms.randomdata.api;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.services.RootService;

@Controller
@RequestMapping("api")
public class RandomApiController {

	@Autowired
	RootService rootService;

	@GetMapping("/save")
	public String saveRandomApi() {

		try {
			for (int i = 0; i < 100; i++) {
				Root rootObj = rootService.callRandomApi();
				rootService.save(rootObj);

				System.out.println("Record is saved -- " + i + "th");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "Record is saved !!";
	}

}
