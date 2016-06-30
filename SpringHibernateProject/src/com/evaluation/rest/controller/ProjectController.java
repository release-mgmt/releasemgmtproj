package com.evaluation.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.rest.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projServ;
	
	 int empID;
	@RequestMapping(value = "/empId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int getEmployeeId(){
        int empId=projServ.getEmployeeId();//send user name as a parameter
        empID=empId;
        return empId;
    }
	
	@RequestMapping(value = "/getProjects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getEmployeeProject(){
		System.out.println(empID);
        List projectList=projServ.getEmpProject(empID);
        return projectList;
    }
	

	@RequestMapping(value = "/insertProject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertNewProject(){
        	projServ.insertProject();
        return "New project Inserted";
    }
	
}
