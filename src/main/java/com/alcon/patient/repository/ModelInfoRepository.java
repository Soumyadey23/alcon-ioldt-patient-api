package com.alcon.patient.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.ModelInfo;

@Repository
public interface ModelInfoRepository extends CrudRepository<ModelInfo, Integer> {

	@Query("Select x from com.alcon.patient.entity.ModelInfo x where x.surgeon.surgeonId=:surgeonId")
	ModelInfo findOneBySurgeonId(Integer surgeonId);

}
