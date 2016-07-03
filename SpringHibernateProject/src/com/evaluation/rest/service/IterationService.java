package com.evaluation.rest.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.Dao.IterationDao;
import com.evaluation.pojo.IterationInfo;
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
	
	public List getIterationBySearch(String searchCriteria,String key){
		List iterationList=itDao.gettingIterationBySearch(searchCriteria, key);
		return iterationList;
	}
	public List getIterationByDate(String startDate,String endDate){
		List iterationList=itDao.getIterationByDate(startDate, endDate);
		return iterationList;
	}
	public int insertIteration(int release_id,IterationInfo it){
		int iteration_id=itDao.insertIteration(release_id,it);
		return iteration_id;
	}
	
	public void deleteIteration(int iteration_id){
		itDao.deletinIteration(iteration_id);
	}

	public String updateIteration(IterationInfo iteration){
		System.out.println("in service and updating iteraion");
		String updateStatus = itDao.updateIteration(iteration);
		return updateStatus;
	}
}
