package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TresureHuntDao;
import com.model.TresureHuntModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TresureHuntController {
	
	@Autowired
	TresureHuntDao tresureHuntDao;

	@RequestMapping(value="/getTresureHunt",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<TresureHuntModel> getPartInventoryRecordForClient(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
	
		 
		TresureHuntModel thresureHunt=tresureHuntDao.getTresureHunt();
		
		return new ResponseEntity<TresureHuntModel>(thresureHunt, HttpStatus.OK);
	}

}
