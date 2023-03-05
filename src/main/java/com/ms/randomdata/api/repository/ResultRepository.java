package com.ms.randomdata.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.randomdata.api.models.Root;

public interface ResultRepository extends JpaRepository<Root, Integer> {

}
