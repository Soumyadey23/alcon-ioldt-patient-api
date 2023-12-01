
package com.alcon.patient.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_modelmetrics")
@Getter
@Setter
@IdClass(ModelMetricsId.class)
public class ModelMetrics {

	@Id
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "modelid", referencedColumnName = "modelid", nullable = false)
	private ModelInfo model;

	@Column(name = "metricvalue")
	private Float metricValue;

	@Id
	@Column(name = "metrictype")
	private String metricType;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}