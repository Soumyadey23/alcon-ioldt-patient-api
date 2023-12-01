package com.alcon.patient.dto.card;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestDTO {
	private String caseId;
	private String lensName;
	private Integer surgeonId;
	private Integer applicationId; 

}