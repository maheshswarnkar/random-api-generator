package com.ms.randomdata.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.randomdata.api.models.Root;
import com.ms.randomdata.api.repository.ResultRepository;

@Service
public class RootService {

	@Autowired
	ResultRepository repository;

	public void save(Root root) {
		System.out.print("Before saving");
		repository.save(root);
		System.out.println("Record is saved");
	}
}
