
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

@Entity(name = "t_questions")
@Getter
@Setter
public class Questions {
    
		@Id
//		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "questionid")
	    private Integer questionId;
		
		@Column(name = "questiontext", unique = true)
	    private String questionText;
		
		@Column(name = "questionsequence")
	    private Integer questionSeq;
		
		@Column(name="datecreatedwhen")
		@CreationTimestamp
		private Timestamp dateCreatedWhen;

		@Column(name = "questionabbreviatedlabel")
	    private String questionAbbreviatedLabel;
		
		@Column(name = "questionsource")
	    private String questionSource;
		
		@Column(name = "selectionvalue")
	    private String selectionValue;
		
		@Column(name = "selectiontype")
	    private String selectionType;
}