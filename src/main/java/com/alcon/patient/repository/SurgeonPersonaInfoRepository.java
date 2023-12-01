package com.alcon.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.SurgeonPersonaInfo;

@Repository
public interface SurgeonPersonaInfoRepository extends CrudRepository<SurgeonPersonaInfo, Integer>{
	
}