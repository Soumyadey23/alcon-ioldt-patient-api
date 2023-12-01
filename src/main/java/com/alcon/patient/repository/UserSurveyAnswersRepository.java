package com.alcon.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.dto.list.CustomPatientList;
import com.alcon.patient.entity.UserSurveyAnswers;

@Repository
public interface UserSurveyAnswersRepository extends CrudRepository<UserSurveyAnswers, Integer> {

	@Query(value = "SELECT DISTINCT x.userSurvey.id FROM com.alcon.patient.entity.UserSurveyAnswers x WHERE x.question.questionSource=:source and x.userSurvey.isSurgeonCaseFlag=:isSurgeonCaseFlag", nativeQuery = false)
	public List<String> getPatientList(String source, Boolean isSurgeonCaseFlag);

	@Query(value = "SELECT new com.alcon.patient.dto.list.CustomPatientList(x.userSurvey.id, x.question.questionId, x.answer.answerId, x.question.questionSeq, x.question.questionAbbreviatedLabel, x.question.questionText, x.question.selectionType, x.question.questionSource) FROM com.alcon.patient.entity.UserSurveyAnswers x WHERE x.userSurvey.id IN (:userSurveyId) ORDER by x.question.questionSeq", nativeQuery = false)
	public List<CustomPatientList> getUnsortedCards(List<String> userSurveyId);
}