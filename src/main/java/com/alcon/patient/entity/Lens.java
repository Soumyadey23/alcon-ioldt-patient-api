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

@Entity(name = "t_Lens")
@Getter
@Setter
public class Lens {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "lensid")
	private Integer lensId;
	
	@Column(name="lensname")
	private String lensName;
	
	@Column(name="datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}
