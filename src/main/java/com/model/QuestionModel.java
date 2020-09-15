package com.model;

import java.util.List;

import com.entity.OptionEntity;

import lombok.Data;
@Data
public class QuestionModel {

	private Integer qusId;
	private List<OptionEntity> getOption;
}
