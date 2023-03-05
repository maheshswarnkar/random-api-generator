package com.ms.randomdata.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.randomdata.api.converter.RequestToModelConverter;
import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.request.objects.Result;

/**
 * @author MAHESH
 *
 */
public class GetJsonObject {

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

	public static void main(String[] args) throws MalformedURLException {
		String stringURI = "https://randomuser.me/api/";
		URL url = new URL(stringURI);
		Result resultPojo = getJsonObjectMapper(url, Result.class);
		System.out.println("Print result " + resultPojo);

		RequestToModelConverter requestToModelObjectConverter = new RequestToModelConverter();
		Root root = requestToModelObjectConverter.requestToModelObjectConverter(resultPojo);

		System.out.println("Root \n" + root);

	}

}
