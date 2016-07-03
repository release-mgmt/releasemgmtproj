package com.evaluation.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.Dao.ProjectInfoDao;
import com.evaluation.pojo.ProjectInfo;

@Service
public class ProjectService {
	@Autowired
	private ProjectInfoDao projDao;
	
	/*public int getEmployeeId(){
		int emp_id= projDao.getEmployeeID("kedarpi");
		return emp_id;
	}*/
	
	public List getEmpProject(int empId){
		List projectList=projDao.getEmpProjects(empId);
		return projectList;
	}
	
	public int insertProject(int employee_id,ProjectInfo pro){
		int project_id=projDao.insertProject(employee_id,pro);
		return project_id;
	}
}
