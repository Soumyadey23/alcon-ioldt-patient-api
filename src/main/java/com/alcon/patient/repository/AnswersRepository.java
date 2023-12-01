package com.alcon.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.Answers;

@Repository
public interface AnswersRepository extends CrudRepository<Answers, Integer> {

	@Query(value = "SELECT x FROM com.alcon.patient.entity.Answers x WHERE x.question.questionSource=:source and x.answerSequence!=:answerSequence ORDER by x.question.questionSeq, x.question.questionId ,x.answerSequence", nativeQuery = false)
	public List<Answers> getQuestionAnswersList(String source, Integer answerSequence);

}