package com.alcon.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.dto.card.CustomSortedLens;
import com.alcon.patient.entity.ModelLabel;

@Repository
public interface ModelLabelRepository extends CrudRepository<ModelLabel, Integer>{
	
	@Query(value="SELECT x.userSurvey.id FROM com.alcon.patient.entity.ModelLabel x WHERE x.surgeon.surgeonId=:surgeonId" , nativeQuery = false)
	 public List<String> getLabelledPatientList(Integer surgeonId);
	
	@Query(value = "SELECT new com.alcon.patient.dto.card.CustomSortedLens(x.userSurvey.id, x.lensName, l.lensId, x.dateCreatedWhen) FROM com.alcon.patient.entity.ModelLabel x inner join com.alcon.patient.entity.Lens l on l.lensName=x.lensName WHERE x.surgeon.surgeonId=:surgeonId ORDER by x.dateCreatedWhen desc", nativeQuery = false)
	public List<CustomSortedLens> getSortedLensList(Integer surgeonId);

	
	@Query(value="Select x from com.alcon.patient.entity.ModelLabel x WHERE x.userSurvey.id=:userSurveyId and x.surgeon.surgeonId=:surgeonId",nativeQuery = false)
	public ModelLabel findAllByUserSurveyIdAndPersonaId(String userSurveyId, Integer surgeonId);
	
	
	@Query(value="Insert into com.alcon.patient.entity.ModelLabel(surgeon.surgeonId, userSurvey.id, lensName, dateCreatedWhen) values(:surgeonId, :userSurveyId, :lensName, CURRENT_TIMESTAMP)", nativeQuery = false)
	public Integer saveLabelledCard(Integer surgeonId, String userSurveyId, String lensName);
	 
}