package com.ms.randomdata.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.randomdata.api.converter.RequestToModelConverter;
import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.request.objects.Result;
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
				Root rootObj = callRandomApi();
				rootService.save(rootObj);

				System.out.println("Record is saved -- " + i + "th");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "Record is saved !!";
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

		System.out.println("Root \n" + root);
		return root;

	}
}
