package com.dao;

import java.util.List;

import com.entity.OptionEntity;
import com.entity.QuetionEntity;
import com.entity.UserEntity;
import com.model.QuestionModel;
import com.model.TresureHuntModel;

public interface TresureHuntDao {

	
	public List<OptionEntity> listOfOption(Integer qusId);
	
	public List<QuestionModel> listOfQus(Integer tressureHuntId);
	
	public List<UserEntity> listOfParticipate(String userRole);
	
	public TresureHuntModel getTresureHunt();
}
