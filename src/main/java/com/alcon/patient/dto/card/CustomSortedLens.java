package com.alcon.patient.dto.card;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomSortedLens {
	private String userSurveyId;
	private String lensName;
	private Integer lensId;
	private Timestamp dateCreated;
	
	public CustomSortedLens() {
		super();
	}

	public CustomSortedLens(String userSurveyId, String lensName, Integer lensId, Timestamp dateCreated) {
		super();
		this.userSurveyId = userSurveyId;
		this.lensName = lensName;
		this.lensId = lensId;
		this.dateCreated = dateCreated;
	}
	
}
