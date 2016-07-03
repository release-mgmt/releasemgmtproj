package com.releasemanagement.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.releasemanagement.pojo.ProjectInfo;
import com.releasemanagement.rest.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projServ;

	@RequestMapping(value = "/getProjects/{emp_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getEmployeeProject(@PathVariable int emp_id) {
		List projectList = projServ.getEmpProject(emp_id);
		return projectList;
	}

	@RequestMapping(value = "/insertProject/{empId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer insertNewProject(@PathVariable int empId, @RequestBody ProjectInfo pro) {
		int project_id = projServ.insertProject(empId, pro);
		return project_id;
	}

}