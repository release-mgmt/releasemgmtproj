package com.releasemanagement.rest.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.releasemanagement.pojo.Dummy;
import com.releasemanagement.pojo.Employee;
import com.releasemanagement.rest.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class EmployeeController {

	@Autowired
	private EmployeeService empServ;

	/*
	 * @RequestMapping(value = "/authenticateUser", method = RequestMethod.GET,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public String[]
	 * getEmployee(){
	 * 
	 * Employee e=empServ.aunticationUser(); if(e!=null) { String[]
	 * empDetails={((Integer)e.getEmployeeId()).toString(),e.getEmployeeRoleId()
	 * .getRoleDefinition(),e.getEmployeeUsername()}; return empDetails; } else{
	 * String [] message={"Sorry no data found"}; return message; } }
	 */
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dummy getEmployee(@RequestBody Dummy emp) {
/*		System.out.println("in authenticate user");
		System.out.println(emp.toString());
		System.out.println(emp.getUserName());
		System.out.println(emp.getPassword());
*/		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		 Matcher username = p.matcher(emp.getUserName());
		 Matcher password=p.matcher(emp.getPassword());
		if(!(username.find() && password.find())){
			System.out.println( "there is no special charecter in string");
			Employee e = empServ.aunticationUser(emp.getUserName(), emp.getPassword());
			if (e != null) {
				emp.setPassword(null);
				emp.setEmpId(e.getEmployeeId());
				emp.setEmpRole(e.getEmployeeRoleId().getRoleDefinition());
				System.out.println("returned to view: "+emp);
				System.out.println(e.getEmployeeId());
				return emp;
			} else {
				
				emp.setPassword(null);
				
				//String[] message ={ "Sorry no data found"};
				return emp;
			}
			
			
		}else{
			System.out.println( "there is special charecter in string");
			emp.setPassword(null);
			return emp;
		}
		
		
	}
	
}
