package com.alcon.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.Questions;

@Repository
public interface QuestionsRepository extends CrudRepository<Questions, Integer>{
	
}