package com.evaluation.rest.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.pojo.IterationInfo;
import com.evaluation.rest.service.IterationService;
import com.evaluation.rest.service.ProjectService;

@RestController
@RequestMapping("/project")
public class IterationController {
	@Autowired
	private IterationService itServ;

	@RequestMapping(value = "/getAllIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getAllIterations() {
		List projectList = itServ.getAllIterations();
		return projectList;
	}

	@RequestMapping(value = "/getReleaseIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getReleaseIterationList() {
		// provide release id for fetching the iterations for perticular release
		List projectList = itServ.getReleaseIterationList();
		return projectList;
	}

	@RequestMapping(value = "/getIterationsBySearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getIterationBySearch() {
		// take input from the user which search criteria and the value
		List iterationList = itServ.getIterationBySearch("type", "QA");
		return iterationList;
	}

	@RequestMapping(value = "/getIterationsByDates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getIterationByDates() {
		// take the start date and end date from page
		List projectList = itServ.getIterationByDate("2015/04/01", "2016/03/07");
		return projectList;
	}

	@RequestMapping(value = "/insertIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int insertIteration() {
		// take the releaseId form the user or page
		int iteration_id = itServ.insertIteration(7);
		return iteration_id;
	}

	@RequestMapping(value = "/deleteIteration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteIteration() {
		// take the iteration id from the user or page
		itServ.deleteIteration(12);
		return "new iteration delete";
	}

	// ---------------------------------------------------------
	// here , requestMethod needs to be changed to POST
	// produces ---> consumes (json data will be received in JSON)
	// Pass the argument to this method, and check weather is it working with or
	// without @RequestBody
	// manage the mapping of the attributes of the object - iterationInfo
	@RequestMapping(value = "/updateIteration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateIteration(/* IterationInfo iteraion */) throws Exception {

		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 = df.parse("02-7-2016"); // for example, today's date
		Date d2 = df.parse("21-7-2016"); // use your own dates, of course
		IterationInfo iteration = new IterationInfo(5, "updated Iteraion title", "updated iteration description", d1,
				d2, "status updated completed", "Dev updated");

		String updateStatus = itServ.updateIteration(iteration);
		return updateStatus;
	}
}
