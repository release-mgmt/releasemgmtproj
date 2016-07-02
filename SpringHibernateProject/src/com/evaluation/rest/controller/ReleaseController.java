package com.evaluation.rest.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.Dao.ReleaseDao;
import com.evaluation.pojo.ProjectInfo;
import com.evaluation.pojo.ReleaseInfo;
import com.evaluation.rest.service.ReleaseService;

@RestController
@RequestMapping("/project")
public class ReleaseController {
	public final Logger logger = Logger.getLogger(ReleaseDao.class.getName());

	@Autowired
	private ReleaseService relServ;

	@RequestMapping(value = "/releaseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReleaseInfo> getReleaseDetails() {

		// ReleaseInfo details=rs.getReleaseDetails();
		List<ReleaseInfo> details = relServ.getAllReleaseDetails();
	
		return details;
	}

	@RequestMapping(value = "/projectReleaseList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getProjReleaseList() {
		List projRelease = relServ.getProjReleaselist();
		return projRelease;
	}

	@RequestMapping(value = "/releaseListByCriteria", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getReleaseDetailsByCriteria() {
		// take the search criteria and key value from the user
		List criteriaResult = relServ.getReleaseBySearch("title", "abc");
		return criteriaResult;
	}

	@RequestMapping(value = "/releaseListByDates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getReleaseDetailsByDates() {

		// ReleaseInfo details=rs.getReleaseDetails();
		List criteriaResult = relServ.getReleaseByDate("2017/08/06", "2017/10/06");
		return criteriaResult;
	}

	@RequestMapping(value = "/insertRelease", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int insertRelease() {
		// pass the project_id
		int release_id = relServ.insertProjRelease(2);
		return release_id;
	}

	@RequestMapping(value = "/deleteRelease", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteRelease() {
		relServ.deleteRelease(11);
		return "new release deleted";
	}

	// ---------------------------------------------------------
	// here , requestMethod needs to be changed to POST
	// produces ---> consumes (json data will be received in JSON)
	// Pass the argument to this method, and check weather is it working with or
	// without @RequestBody
	// manage the mapping of the attributes of the objecct - ReleaseInfo

	@RequestMapping(value = "/updateRelease", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateProject(/* ProjectInfo project */) throws Exception {

		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 = df.parse("02-7-2016"); // for example, today's date
		Date d2 = df.parse("21-7-2016"); // use your own dates, of course
		ReleaseInfo release = new ReleaseInfo(7, "updated release title for 7", "updated release description", d1, d2, d2,
				"MileStone", "update QA", "update working", "v1.0.0.0");
		String updateStatus = relServ.updateRelease(release);
		return updateStatus;
	}

}
