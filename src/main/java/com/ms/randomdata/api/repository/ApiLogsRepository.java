package com.ms.randomdata.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.randomdata.api.models.ApiLogs;

@Repository
public interface ApiLogsRepository extends JpaRepository<ApiLogs, Long> {

}
