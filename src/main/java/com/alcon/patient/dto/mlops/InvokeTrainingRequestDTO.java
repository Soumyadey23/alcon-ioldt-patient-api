package com.alcon.patient.dto.mlops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvokeTrainingRequestDTO {

	private String surgeon_id;
	private Integer model_id;
	private Boolean is_champion;
	private Boolean is_personalized = false;
}
