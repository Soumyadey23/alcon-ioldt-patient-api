package com.alcon.patient.dto.list;

public class CustomPatientList {

	private String userSurveyid;
	private Integer questionId;
	private Integer answerOptionId;
	private Integer questionsequence;
	private String questionAbbreviatedLabel;
	private String questionText;
	private String selectionType;
	private String questionTource;

	public CustomPatientList(String userSurveyid, Integer questionId, Integer answerOptionId, Integer questionsequence,
			String questionAbbreviatedLabel, String questionText, String selectionType, String questionTource) {
		super();
		this.userSurveyid = userSurveyid;
		this.questionId = questionId;
		this.answerOptionId = answerOptionId;
		this.questionsequence = questionsequence;
		this.questionAbbreviatedLabel = questionAbbreviatedLabel;
		this.questionText = questionText;
		this.selectionType = selectionType;
		this.questionTource = questionTource;
	}

	public CustomPatientList() {
		super();
	}

	public String getUserSurveyid() {
		return userSurveyid;
	}

	public void setUserSurveyid(String userSurveyid) {
		this.userSurveyid = userSurveyid;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(Integer answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	public Integer getQuestionsequence() {
		return questionsequence;
	}

	public void setQuestionsequence(Integer questionsequence) {
		this.questionsequence = questionsequence;
	}

	public String getQuestionAbbreviatedLabel() {
		return questionAbbreviatedLabel;
	}

	public void setQuestionAbbreviatedLabel(String questionAbbreviatedLabel) {
		this.questionAbbreviatedLabel = questionAbbreviatedLabel;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getSelectionType() {
		return selectionType;
	}

	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}

	public String getQuestionTource() {
		return questionTource;
	}

	public void setQuestionTource(String questionTource) {
		this.questionTource = questionTource;
	}

}
