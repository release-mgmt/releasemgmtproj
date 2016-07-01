package com.evaluation.rest.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.rest.service.IterationService;
import com.evaluation.rest.service.ProjectService;

@RestController
@RequestMapping("/project")
public class IterationController {
	@Autowired
	private IterationService itServ;
	

	@RequestMapping(value = "/getAllIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAllIterations(){
        List projectList=itServ.getAllIterations();
        return projectList;
    }
	
	@RequestMapping(value = "/getReleaseIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getEmployeeProject(){
        List projectList=itServ.getReleaseIterationList();
        return projectList;
    }
	
	@RequestMapping(value = "/insertIterations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int insertIteration() throws ParseException {
        int iteration_id=itServ.insertIteration(7);
        return iteration_id;
    }
	@RequestMapping(value = "/deleteIteration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteIteration() {
        itServ.deleteIteration(12);
        return "new iteration delete";
    }
}
