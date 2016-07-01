package com.evaluation.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.Dao.EmployeeDao;
import com.evaluation.pojo.Employee;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	public Employee aunticationUser(){
		
		Employee e=empDao.authenticateUser("nikhilg", "12345");
		
		//String [] empDetails={((Integer)e.getEmployeeId()).toString(),e.getEmployee_roleDef()};
		return e;
	}
}