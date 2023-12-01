package com.alcon.patient.dto.card;

public class QuestionAnswerDTO {
	private String answer;
	private Integer answerSequence;
	private Integer numberOfOptions;
	private Integer modelId;
	private String optionsText;
	private String questionCategory;
	private String questionDesc;
	private Integer questionId;
	private Integer questionSeq;
	private Integer weightage;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getAnswerSequence() {
		return answerSequence;
	}

	public void setAnswerSequence(Integer answerSequence) {
		this.answerSequence = answerSequence;
	}

	public Integer getNumberOfOptions() {
		return numberOfOptions;
	}

	public void setNumberOfOptions(Integer numberOfOptions) {
		this.numberOfOptions = numberOfOptions;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getOptionsText() {
		return optionsText;
	}

	public void setOptionsText(String optionsText) {
		this.optionsText = optionsText;
	}

	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getQuestionSeq() {
		return questionSeq;
	}

	public void setQuestionSeq(Integer questionSeq) {
		this.questionSeq = questionSeq;
	}

	public Integer getWeightage() {
		return weightage;
	}

	public void setWeightage(Integer weightage) {
		this.weightage = weightage;
	}

}