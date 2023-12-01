
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
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_answeroptions" )
@Getter
@Setter
public class Answers {
    
		@Id
//		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "answerid")
	    private Integer answerId;
		
		@ManyToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name = "questionid", referencedColumnName = "questionid", nullable = false)
		private Questions question;
		
		@Column(name = "answersequence")
	    private Integer answerSequence;
		

		@Column(name = "answerscore")
	    private Integer answerScore;
		
		@Column(name = "answertext")
	    private String answerText;
		
		
		@Column(name="datecreatedwhen")
		@CreationTimestamp
		private Timestamp dateCreatedWhen;
		
		
}