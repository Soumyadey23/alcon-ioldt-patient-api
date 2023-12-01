package com.alcon.patient.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelMetricsId {

	private ModelInfo model;

	private String metricType;

	public ModelMetricsId(ModelInfo model, String metricType) {
		super();
		this.model = model;
		this.metricType = metricType;
	}

	public ModelMetricsId() {
		super();
	}
}