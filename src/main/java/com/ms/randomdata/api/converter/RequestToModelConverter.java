package com.ms.randomdata.api.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ms.randomdata.api.models.ModelId;
import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.request.objects.Coordinates;
import com.ms.randomdata.api.request.objects.Dob;
import com.ms.randomdata.api.request.objects.Id;
import com.ms.randomdata.api.request.objects.Info;
import com.ms.randomdata.api.request.objects.Location;
import com.ms.randomdata.api.request.objects.Login;
import com.ms.randomdata.api.request.objects.Name;
import com.ms.randomdata.api.request.objects.Picture;
import com.ms.randomdata.api.request.objects.Registered;
import com.ms.randomdata.api.request.objects.Result;
import com.ms.randomdata.api.request.objects.Street;
import com.ms.randomdata.api.request.objects.Timezone;
import com.ms.randomdata.api.request.objects.RequestResult;

public class RequestToModelConverter {

	private void infoConverter(Info reqInfo, com.ms.randomdata.api.models.Info modelInfo) {
		modelInfo.setPage(String.valueOf(reqInfo.getPage()));
		modelInfo.setResults(String.valueOf(reqInfo.getResults()));
		modelInfo.setSeed(reqInfo.getSeed());
		modelInfo.setVersion(reqInfo.getVersion());
	}

	/**
	 * @param requestResult
	 * @param root
	 * @return
	 */
	public Root requestToModelObjectConverter(Result requestResult) {

		RequestToModelConverter converter = new RequestToModelConverter();

		Root root = new Root();
		com.ms.randomdata.api.models.Result modelResult = new com.ms.randomdata.api.models.Result();
		com.ms.randomdata.api.models.Info modelInfo = new com.ms.randomdata.api.models.Info();
		Info reqInfo = requestResult.getInfo();
		converter.infoConverter(reqInfo, modelInfo);

		List<com.ms.randomdata.api.models.Result> modelResultList = new ArrayList<>();

		List<RequestResult> results = requestResult.getResults();

		for (Iterator<RequestResult> iterator = results.iterator(); iterator.hasNext();) {
			RequestResult reqResult = iterator.next();

			Login reqLogin = reqResult.getLogin();
			com.ms.randomdata.api.models.Login modelLogin = new com.ms.randomdata.api.models.Login();
			Registered reqReg = reqResult.getRegistered();
			com.ms.randomdata.api.models.Registered modelReg = new com.ms.randomdata.api.models.Registered();
			Picture reqPicture = reqResult.getPicture();
			com.ms.randomdata.api.models.Picture modelPicture = new com.ms.randomdata.api.models.Picture();
			Id reqId = reqResult.getId();
			ModelId modelId = new ModelId();
			Name reqName = reqResult.getName();
			com.ms.randomdata.api.models.Name modelName = new com.ms.randomdata.api.models.Name();

			Dob reqDob = reqResult.getDob();
			com.ms.randomdata.api.models.Dob modelDob = new com.ms.randomdata.api.models.Dob();

			Location reqLocation = reqResult.getLocation();
			com.ms.randomdata.api.models.Location modelLocation = new com.ms.randomdata.api.models.Location();

			nameConverter(reqName, modelName);
			locationConverter(reqLocation, modelLocation);
			loginConverter(reqLogin, modelLogin);
			dobConverter(reqDob, modelDob);
			registeredConverter(reqReg, modelReg);
			idConverter(reqId, modelId);
			pictureConverter(reqPicture, modelPicture);

			modelResult.setName(modelName);
			modelResult.setLocation(modelLocation);
			modelResult.setLogin(modelLogin);
			modelResult.setDob(modelDob);
			modelResult.setRegistered(modelReg);
			modelResult.setModelId(modelId);
			modelResult.setPicture(modelPicture);

			modelResult.setCell(reqResult.getCell());
			modelResult.setGender(reqResult.getGender());
			modelResult.setEmail(reqResult.getEmail());
			modelResult.setPhone(reqResult.getPhone());
			modelResult.setCell(reqResult.getCell());
			modelResult.setNat(reqResult.getNat());

//			modelResultList.add(modelResult);
			root.setInfo(modelInfo);

			root.setResult(modelResult);
		}

		return root;
	}

	private void pictureConverter(Picture reqPicture, com.ms.randomdata.api.models.Picture modelPicture) {
		modelPicture.setLarge(reqPicture.getLarge());
		modelPicture.setMedium(reqPicture.getMedium());
		modelPicture.setThumbnail(reqPicture.getThumbnail());
	}

	private void idConverter(Id reqId, com.ms.randomdata.api.models.ModelId modelId) {
		modelId.setName(reqId.getName());
		modelId.setValue(reqId.getValue());
	}

	private void registeredConverter(Registered reqReg, com.ms.randomdata.api.models.Registered modelReg) {
		modelReg.setRegAge(reqReg.getAge());
		modelReg.setRegDate(reqReg.getDate());
	}

	private void loginConverter(Login reqLogin, com.ms.randomdata.api.models.Login modelLogin) {
		modelLogin.setMd5(reqLogin.getMd5());
		modelLogin.setPassword(reqLogin.getPassword());
		modelLogin.setSalt(reqLogin.getSalt());
		modelLogin.setSha1(reqLogin.getSha1());
		modelLogin.setSha256(reqLogin.getSha256());
		modelLogin.setUsername(reqLogin.getUsername());
		modelLogin.setUuid(reqLogin.getUuid());
	}

	private void locationConverter(Location reqLocation, com.ms.randomdata.api.models.Location modelLocation) {
		Street reqStreet = reqLocation.getStreet();
		com.ms.randomdata.api.models.Street modelStreet = new com.ms.randomdata.api.models.Street();
		Coordinates reqCoordinates = reqLocation.getCoordinates();
		com.ms.randomdata.api.models.Coordinates modelCoordinates = new com.ms.randomdata.api.models.Coordinates();
		Timezone reqTimezone = reqLocation.getTimezone();
		com.ms.randomdata.api.models.Timezone modelTimezone = new com.ms.randomdata.api.models.Timezone();

		streetConverter(reqStreet, modelStreet);
		coordinatesConverter(reqCoordinates, modelCoordinates);
		timezoneConverter(reqTimezone, modelTimezone);

		modelLocation.setStreet(modelStreet);
		modelLocation.setCoordinates(modelCoordinates);
		modelLocation.setTimezone(modelTimezone);
		modelLocation.setCity(reqLocation.getCity());
		modelLocation.setCountry(reqLocation.getCountry());
		modelLocation.setPostcode(reqLocation.getPostcode());
		modelLocation.setState(reqLocation.getState());

	}

	private void timezoneConverter(Timezone reqTimezone, com.ms.randomdata.api.models.Timezone modelTimezone) {
		modelTimezone.setDescription(reqTimezone.getDescription());
		modelTimezone.setOffset(reqTimezone.getOffset());
	}

	private void coordinatesConverter(Coordinates reqCoordinates,
			com.ms.randomdata.api.models.Coordinates modelCoordinates) {
		modelCoordinates.setLatitude(reqCoordinates.getLatitude());
		modelCoordinates.setLongitude(reqCoordinates.getLongitude());
	}

	private void streetConverter(Street reqStreet, com.ms.randomdata.api.models.Street modelStreet) {
		modelStreet.setStreetName(reqStreet.getName());
		modelStreet.setStreetNumber(String.valueOf(reqStreet.getNumber()));
	}

	private void nameConverter(Name reqName, com.ms.randomdata.api.models.Name modelName) {
		modelName.setFirst(reqName.getFirst());
		modelName.setLast(reqName.getLast());
		modelName.setTitle(reqName.getTitle());
	}

	private void dobConverter(Dob reqDob, com.ms.randomdata.api.models.Dob modelDob) {
		modelDob.setDobAge(reqDob.getAge());
		modelDob.setDobDate(reqDob.getDate());
	}

}
