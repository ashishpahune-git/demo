package com.model;

import java.util.List;

import com.entity.UserEntity;

import lombok.Data;
@Data
public class TresureHuntModel {

	private Integer id;
	private String thresureHunt;
	private List<QuestionModel> qusList;
	private List<UserEntity> participate;
	
}
