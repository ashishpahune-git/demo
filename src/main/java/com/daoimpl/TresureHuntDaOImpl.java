package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.dao.TresureHuntDao;
import com.entity.OptionEntity;
import com.entity.QuetionEntity;
import com.entity.ThresureHuntEntity;
import com.entity.UserEntity;
import com.model.QuestionModel;
import com.model.TresureHuntModel;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TresureHuntDaOImpl implements TresureHuntDao{

	@Autowired
	TresureHuntDao tresureHuntDao;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<OptionEntity> listOfOption(Integer qusId) {
		List<OptionEntity> optionList = null;
		try {
			optionList = entityManager.createQuery(
					"select optionEntity from OptionEntity optionEntity where optionEntity.qusId=:qusId",
					OptionEntity.class).setParameter("qusId", qusId).getResultList();

		} catch (Exception e) {
			log.error("Could not fetch list of Objective.");

			e.printStackTrace();
		}

		return optionList;

	}


	@Override
	public List<QuestionModel> listOfQus(Integer tressureHuntId) {
		List<QuetionEntity> qusList = null;
		List<QuestionModel> qusionList = new ArrayList<QuestionModel>();
		try {
			qusList = entityManager.createQuery(
					"select quetionEntity from QuetionEntity quetionEntity where quetionEntity.tressureHuntId=:tressureHuntId",
					QuetionEntity.class).setParameter("tressureHuntId", tressureHuntId).getResultList();
			QuestionModel model=null;

			for (QuetionEntity quetionEntity : qusList) {
				model = new QuestionModel();
				model.setQusId(quetionEntity.getQutId());
				if(quetionEntity.getQutId() !=0){
					model.setGetOption(tresureHuntDao.listOfOption(quetionEntity.getQutId()));
				}
				qusionList.add(model);
			}
		} catch (Exception e) {
			log.error("Could not fetch list of Quetion.");

			e.printStackTrace();
		}

		return qusionList;

	}

	@Override
	public List<UserEntity> listOfParticipate(String userRole) {
		List<UserEntity> userList = null;
		try {
			userList = entityManager.createQuery(
					"select userEntity from UserEntity userEntity where userEntity.userRole=:userRole",
					UserEntity.class).setParameter("userRole", userRole).getResultList();

		} catch (Exception e) {
			log.error("Could not fetch list of Participate List.");

			e.printStackTrace();
		}

		return userList;

	}

	@Override
	public TresureHuntModel getTresureHunt() {
		ThresureHuntEntity thEntity = null;
		TresureHuntModel model=null;
		String userRole="Participate";
		try {
			String thresureHuntname="TRESUREHUNT";
			thEntity = entityManager.createQuery(
					"select c from ThresureHuntEntity c where c.thresureHuntname=:thresureHuntname",
					ThresureHuntEntity.class).setParameter("thresureHuntname", thresureHuntname).getSingleResult();


			    if(thEntity != null) {
				model = new TresureHuntModel();
				model.setId(thEntity.getThId());
				model.setThresureHunt(thEntity.getThresureHuntname());

				if(thEntity.getThId() !=0){
					model.setParticipate(tresureHuntDao.listOfParticipate(userRole));
					model.setQusList(tresureHuntDao.listOfQus(thEntity.getThId()));
				}
				
			}
		} catch (Exception e) {
			log.error("Could not fetch Tresure Hunt Details.");

			e.printStackTrace();
		}

		return model;

	} 

}
