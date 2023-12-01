
package com.alcon.patient.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_modellabel")
@Qualifier(value = "ModelLabel")
@Getter
@Setter	
public class ModelLabel {

	@Id
	//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="t_modellabel_id_seq")
	@SequenceGenerator(name="t_modellabel_id_seq",sequenceName="t_modellabel_id_seq",allocationSize=1)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "usersurveyid", referencedColumnName = "id", nullable = false)
	private Users userSurvey;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "sgnid", referencedColumnName = "sgnid", nullable = false)
	private Surgeon surgeon;

	@Column(name = "lensname")
	private String lensName;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;
}