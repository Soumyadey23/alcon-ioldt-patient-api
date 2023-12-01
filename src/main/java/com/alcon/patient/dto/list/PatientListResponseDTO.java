package com.alcon.patient.dto.list;

import java.util.List;

public class PatientListResponseDTO {
	private List<CaseDetailsDTO> body;

	public List<CaseDetailsDTO> getBody() {
		return body;
	}

	public void setBody(List<CaseDetailsDTO> body) {
		this.body = body;
	}

}