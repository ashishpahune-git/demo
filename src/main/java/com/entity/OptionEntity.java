package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="option")
public class OptionEntity {

	private Integer id;
	private String objective;
	private Integer qusId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "objective")
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}

	@ManyToOne
	@JoinColumn(name = "qus_id", referencedColumnName = "qus_id", nullable=false)	
	public Integer getQusId() {
		return qusId;
	}
	public void setQusId(Integer qusId) {
		this.qusId = qusId;
	}
}
