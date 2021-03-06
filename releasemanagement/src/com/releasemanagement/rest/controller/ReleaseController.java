package com.releasemanagement.rest.controller;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.releasemanagement.dao.ReleaseDao;
import com.releasemanagement.pojo.ReleaseInfo;
import com.releasemanagement.rest.service.ReleaseService;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ReleaseController {
	public final Logger logger = Logger.getLogger(ReleaseDao.class.getName());

	@Autowired
	private ReleaseService relServ;

	@RequestMapping(value = "/releaseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReleaseInfo> getReleaseDetails() {
		List<ReleaseInfo> details = relServ.getAllReleaseDetails();
		return details;
	}

	@RequestMapping(value = "/projectReleaseList/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getProjReleaseList(@PathVariable int projectId) {
		List projRelease = relServ.getProjReleaselist(projectId);
		return projRelease;
	}

	@RequestMapping(value = "/releaseListByCriteria/{searchCriteria}/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getReleaseDetailsByCriteria(@PathVariable String searchCriteria,@PathVariable String value) {
		// take the search criteria and key value from the user
		List criteriaResult = relServ.getReleaseBySearch(searchCriteria,value);
		return criteriaResult;
	}

	@RequestMapping(value = "/releaseListByDates/{startDate}/{endDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getReleaseDetailsByDates(@PathVariable String startDate,@PathVariable String endDate) {

		// ReleaseInfo details=rs.getReleaseDetails();
		List criteriaResult = relServ.getReleaseByDate(startDate,endDate);
		return criteriaResult;
	}

	@RequestMapping(value = "/insertRelease/{projId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer insertRelease(@RequestBody ReleaseInfo r,@PathVariable int projId) {
		// pass the project_id
		Pattern title = Pattern.compile("[^A-Za-z0-9 ]");
		Pattern discription =Pattern.compile("[^A-Za-z0-9 !@#$%.,:]");
		Matcher t=title.matcher(r.getReleaseTitle());
		Matcher d=discription.matcher(r.getReleaseDescription());
		//if(!t.find)
		System.out.println("passed project id :"+projId);
		System.out.println("release title " +r.getReleaseTitle());
		int release_id = relServ.insertR(projId,r);
		return release_id;
	}

	@RequestMapping(value = "/deleteRelease/{releaseId}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> deleteRelease(@PathVariable int releaseId) {
		String status=relServ.deleteRelease(releaseId);
		if(status.equals("deleted")){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/getReleaseInfo/{projectId}/{releaseId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ReleaseInfo getReleaseFullInfo(@PathVariable int projectId, @PathVariable int releaseId){
		ReleaseInfo releaseDetails = relServ.getReleaseFullInfo(projectId,releaseId);
		return releaseDetails;
	}

	// ---------------------------------------------------------
	// here , requestMethod needs to be changed to POST
	// produces ---> consumes (json data will be received in JSON)
	// Pass the argument to this method, and check weather is it working with or
	// without @RequestBody
	// manage the mapping of the attributes of the objecct - ReleaseInfo
/*
	@RequestMapping(value = "/updateRelease/{releaseId}", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProject(@PathVariable int releaseId, @RequestBody ReleaseInfo release) throws Exception {
		String updateStatus = relServ.updateRelease(release);
		
		return updateStatus;
	}
*/

	@RequestMapping(value = "/updateRelease/{releaseId}", method = RequestMethod.PUT, produces = MediaType.ALL_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateProject1(@PathVariable int releaseId, @RequestBody ReleaseInfo release) throws Exception {
		String updateStatus = relServ.updateRelease(release);
	
		return new ResponseEntity<String>(HttpStatus.OK);
	
}
}
