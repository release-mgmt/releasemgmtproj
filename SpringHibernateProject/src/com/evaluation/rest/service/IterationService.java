package com.evaluation.rest.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.Dao.IterationDao;
@Service
public class IterationService {

	@Autowired
	private IterationDao itDao;
	
	

	public List getAllIterations(){
		List projRelease=itDao.iterationList();
		return projRelease;
	}
	
	public List getReleaseIterationList(){
		List releaseIterations=itDao.releaseIterations(1);
		return releaseIterations;
	}
	
	public void insertIteration() throws ParseException{
		itDao.insertIteration();
	}
	
	public void deleteIteration(int iteration_id){
		itDao.deletinIteration(iteration_id);
	}
}
