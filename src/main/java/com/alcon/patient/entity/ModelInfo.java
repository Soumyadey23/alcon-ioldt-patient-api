
package com.alcon.patient.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_modelinfo")	
@Getter
@Setter
public class ModelInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "modelid")
	private Integer modelId;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "sgnid", referencedColumnName = "sgnid", nullable = false)
	private Surgeon surgeon;

	@Column(name = "noofcases")
	private Integer numOfCases;

	@Column(name = "modelstatus")
	private String modelStatus;

	@Column(name = "patterndetectedflag")
	private Boolean patternDetectedFlag;

	@Column(name = "targetmodelurl")
	private String targetModelUrl;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}