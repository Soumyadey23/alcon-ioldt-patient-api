package com.alcon.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.ModelMetrics;

@Repository
public interface ModelMetricsRepository extends CrudRepository<ModelMetrics, Integer>{
	
}