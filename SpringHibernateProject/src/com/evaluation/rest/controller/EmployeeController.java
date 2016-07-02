package com.evaluation.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.pojo.Dummy;
import com.evaluation.pojo.Employee;
import com.evaluation.rest.service.EmployeeService;
import com.evaluation.rest.service.ItemService;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;
	
/*
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] getEmployee(){
		
    	 Employee e=empServ.aunticationUser();
    	 if(e!=null)
    	 {
    		 String[] empDetails={((Integer)e.getEmployeeId()).toString(),e.getEmployeeRoleId().getRoleDefinition(),e.getEmployeeUsername()};
        	return empDetails;
    	 }	
    	 else{
    		 String [] message={"Sorry no data found"};
    		 return  message;
    	 }
    }*/
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
    public String[] getEmployee(@RequestBody Dummy emp){
		System.out.println("in authenticate user");
		System.out.println(emp.toString());
    	 Employee e=empServ.aunticationUser(emp.getUsername(),emp.getPassword());
    	 if(e!=null)
    	 {
    		 String[] empDetails={((Integer)e.getEmployeeId()).toString(),e.getEmployeeRoleId().getRoleDefinition(),e.getEmployeeUsername()};
        	return empDetails;
    	 }	
    	 else{
    		 String [] message={"Sorry no data found"};
    		 return  message;
    	 }
    }
}
