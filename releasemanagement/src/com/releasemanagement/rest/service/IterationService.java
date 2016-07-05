package com.releasemanagement.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.releasemanagement.dao.IterationDao;
import com.releasemanagement.pojo.IterationInfo;

@Service
public class IterationService {

	@Autowired
	private IterationDao itDao;

	public List getAllIterations() {
		List projRelease = itDao.iterationList();
		return projRelease;
	}

	public List getReleaseIterationList(int releaseId) {
		List releaseIterations = itDao.releaseIterations(releaseId);
		return releaseIterations;
	}
	
	public IterationInfo getIterationDetails(int iterationId){
		return itDao.getIterationDetails(iterationId);
	}

	public List getIterationBySearch(String searchCriteria, String key) {
		List iterationList = itDao.gettingIterationBySearch(searchCriteria, key);
		return iterationList;
	}

	public List getIterationByDate(String startDate, String endDate) {
		List iterationList = itDao.getIterationByDate(startDate, endDate);
		return iterationList;
	}

	public int insertIteration(int release_id, IterationInfo it) {
		int iteration_id = itDao.insertIteration(release_id, it);
		return iteration_id;
	}

	public void deleteIteration(int iteration_id) {
		itDao.deletinIteration(iteration_id);
	}

	public String updateIteration(int iterationId, IterationInfo iteration) {
		System.out.println("in service and updating iteraion");
		String updateStatus = itDao.updateIteration(iterationId,iteration);
		return updateStatus;
	}
}
