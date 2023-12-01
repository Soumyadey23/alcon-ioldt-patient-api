package com.alcon.patient.dto.list;

public class MasterResponse {

	private String masterResponseCaseId;
	private Integer masterResponseSelected;
	private Integer questionId;

	public String getMasterResponseCaseId() {
		return masterResponseCaseId;
	}

	public void setMasterResponseCaseId(String masterResponseCaseId) {
		this.masterResponseCaseId = masterResponseCaseId;
	}

	public Integer getMasterResponseSelected() {
		return masterResponseSelected;
	}

	public void setMasterResponseSelected(Integer masterResponseSelected) {
		this.masterResponseSelected = masterResponseSelected;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterResponseCaseId == null) ? 0 : masterResponseCaseId.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MasterResponse other = (MasterResponse) obj;
		if (masterResponseCaseId == null) {
			if (other.masterResponseCaseId != null)
				return false;
		} else if (!masterResponseCaseId.equals(other.masterResponseCaseId))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

}