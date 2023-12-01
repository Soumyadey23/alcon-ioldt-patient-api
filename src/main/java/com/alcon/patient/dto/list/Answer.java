package com.alcon.patient.dto.list;

public class Answer {

	private Integer questionId;
	private Integer answerId;
	private String optionValue;
	private Integer optionWeightage;
	private Integer sequence;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getOptionWeightage() {
		return optionWeightage;
	}

	public void setOptionWeightage(Integer optionWeightage) {
		this.optionWeightage = optionWeightage;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}