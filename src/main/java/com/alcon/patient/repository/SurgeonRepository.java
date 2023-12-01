package com.alcon.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.Surgeon;

@Repository
public interface  SurgeonRepository extends CrudRepository<Surgeon, Integer>{
//    @Transactional
//	void findBySurgeonName(String string);
}
