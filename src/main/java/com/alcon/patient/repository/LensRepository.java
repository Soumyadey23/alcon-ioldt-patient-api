package com.alcon.patient.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.Lens;

@Repository
public interface LensRepository extends CrudRepository<Lens, Integer> {
	
	List<Lens> findAllByOrderByLensId();

}