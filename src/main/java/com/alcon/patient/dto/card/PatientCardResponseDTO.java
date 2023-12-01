package com.alcon.patient.dto.card;

import java.util.List;

public class PatientCardResponseDTO {
	private List<SortedCaseDetailsDTO> lens;
	private Integer numberOfCase;
	private Integer pendingcases;
	private Integer sortedCase;
	private Boolean triggerModel = false;

	public List<SortedCaseDetailsDTO> getLens() {
		return lens;
	}

	public void setLens(List<SortedCaseDetailsDTO> lens) {
		this.lens = lens;
	}

	public Integer getNumberOfCase() {
		return numberOfCase;
	}

	public void setNumberOfCase(Integer numberOfCase) {
		this.numberOfCase = numberOfCase;
	}

	public Integer getPendingcases() {
		return pendingcases;
	}

	public void setPendingcases(Integer pendingcases) {
		this.pendingcases = pendingcases;
	}

	public Integer getSortedCase() {
		return sortedCase;
	}

	public void setSortedCase(Integer sortedCase) {
		this.sortedCase = sortedCase;
	}

	public Boolean getTriggerModel() {
		return triggerModel;
	}

	public void setTriggerModel(Boolean triggerModel) {
		this.triggerModel = triggerModel;
	}

}