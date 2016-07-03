package com.releasemanagement.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.releasemanagement.dao.ReleaseDao;
import com.releasemanagement.pojo.ReleaseInfo;

@Service
public class ReleaseService {

	@Autowired
	private ReleaseDao rd;

	public List<ReleaseInfo> getAllReleaseDetails() {

		List<ReleaseInfo> obj = rd.getReleaseList();
		return obj;
	}

	public List getProjReleaselist(int projectId) {
		List projRelease = rd.getRelease(projectId);
		return projRelease;
	}

	public List getReleaseBySearch(String searchCriteria, String key) {
		List rList = rd.gettingReleasesBySearch(searchCriteria, key);
		return rList;
	}

	public List getReleaseByDate(String s_Date, String e_date) {
		List releaseList = rd.getReleaseByDate(s_Date, e_date);
		return releaseList;
	}

	public List getReleaseFullInfo(int projectId, int releaseId) {
		List releaseList = rd.getReleaseFullInfo(projectId, releaseId);
		return releaseList;
	}

	public int insertR(int project_id, ReleaseInfo r) {
		int r1 = rd.insertRelease(project_id, r);
		return r1;
	}

	public String deleteRelease(int release_id) {
		String status = rd.deletinRelease(release_id);
		return status;
	}

	public String updateRelease(ReleaseInfo release) {
		System.out.println("in service and updating release");
		String updateStatus = rd.updateRelease(release);
		return updateStatus;
	}
}
