package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="thresurehunt_entity")
public class ThresureHuntEntity {

	private Integer thId;
	private String thresureHuntname;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "th_id")
	 public Integer getThId() {
		return thId;
	}
	public void setThId(Integer thId) {
		this.thId = thId;
	}
	
	@Column(name = "thresure_hunt_name")
	public String getThresureHuntname() {
		return thresureHuntname;
	}
	public void setThresureHuntnam(String thresureHuntname) {
		this.thresureHuntname = thresureHuntname;
	}

}
