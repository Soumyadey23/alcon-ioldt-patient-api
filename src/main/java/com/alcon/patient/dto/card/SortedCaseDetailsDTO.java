package com.alcon.patient.dto.card;

import java.util.List;

public class SortedCaseDetailsDTO {
	private List<CaseDTO> cases;
	private Integer lensId;
	private String lensName;
	private Integer sorted;

	public List<CaseDTO> getCases() {
		return cases;
	}

	public void setCases(List<CaseDTO> cases) {
		this.cases = cases;
	}

	public Integer getLensId() {
		return lensId;
	}

	public void setLensId(Integer lensId) {
		this.lensId = lensId;
	}

	public String getLensName() {
		return lensName;
	}

	public void setLensName(String lensName) {
		this.lensName = lensName;
	}

	public Integer getSorted() {
		return sorted;
	}

	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}

}