package com.alcon.patient.dto.list;

import java.util.List;

import com.alcon.patient.dto.card.QuestionAnswerDTO;

public class CaseDetailsDTO {
	private String caseId;
	private String caseName;
	private List<QuestionAnswerDTO> responses;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public List<QuestionAnswerDTO> getResponses() {
		return responses;
	}

	public void setResponses(List<QuestionAnswerDTO> responses) {
		this.responses = responses;
	}

}