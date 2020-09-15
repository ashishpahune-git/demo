package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="quetion_entity")
public class QuetionEntity {

	private Integer qutId;
	private String question;
	private Integer tressureHuntId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qut_id")
	 public Integer getQutId() {
		return qutId;
	}
	public void setQutId(Integer qutId) {
		this.qutId = qutId;
	}
	
	@Column(name = "question")
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}


@Column(name = "th_id")
	public Integer getTresureHuntId() {
		return tressureHuntId;
	}
	public void setTressureHuntId(Integer tressureHuntId) {
		this.tressureHuntId = tressureHuntId;
	} 
}
