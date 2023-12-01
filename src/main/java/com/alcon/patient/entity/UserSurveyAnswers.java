
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_usersurveyanswers")
@Getter
@Setter
public class UserSurveyAnswers {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "usersurveyid", referencedColumnName = "id", nullable = false)
	private Users userSurvey;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "questionid", referencedColumnName = "questionid", nullable = false)
	private Questions question;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "answeroptionid", referencedColumnName = "answerid", nullable = false)
	private Answers answer;

	@Column(name = "datecreatedwhen")
	@CreationTimestamp
	private Timestamp dateCreatedWhen;

}