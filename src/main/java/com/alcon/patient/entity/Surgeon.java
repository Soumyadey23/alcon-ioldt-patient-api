
package com.alcon.patient.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_surgeon")
@Getter
@Setter
public class Surgeon {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "sgnid")
	private Integer surgeonId;

	@Column(name = "sgnsystoken", unique = true)
	private String surgeonName;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}