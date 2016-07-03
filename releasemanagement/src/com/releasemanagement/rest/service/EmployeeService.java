package com.releasemanagement.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.releasemanagement.dao.EmployeeDao;
import com.releasemanagement.pojo.Employee;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	public Employee aunticationUser(String userName,String password){
		
		Employee e=empDao.authenticateUser(userName,password);
		
		//String [] empDetails={((Integer)e.getEmployeeId()).toString(),e.getEmployee_roleDef()};
		return e;
	}
}