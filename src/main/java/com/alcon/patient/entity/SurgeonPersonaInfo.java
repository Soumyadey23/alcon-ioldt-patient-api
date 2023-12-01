
package com.alcon.patient.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_surgeonpersonainfo")
@Getter
@Setter
public class SurgeonPersonaInfo {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "personaid")
	private Integer personaId;

	@Column(name = "personaname")
	private String personaName;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "sgnid", referencedColumnName = "sgnid", nullable = false)
	private Surgeon surgeon;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}