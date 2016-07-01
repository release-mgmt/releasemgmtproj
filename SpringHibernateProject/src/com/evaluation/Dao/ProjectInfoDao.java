package com.evaluation.Dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.evaluation.persistence.HibernateUtil;
import com.evaluation.pojo.Employee;
import com.evaluation.pojo.ProjectInfo;

@Component
public class ProjectInfoDao {

	public  final Logger logger = Logger.getLogger(ProjectInfoDao.class.getName());	
	Employee e;
	//method for fetching all the list of project
	public List getProjectList(){
		   		Session session = HibernateUtil.getSessionFactory().openSession();
		   		List r=session.createQuery("FROM ProjectInfo").list();
		       session.close();
		   return r;
	   }
	//method for fetching the employee id (if u pass the employee Id direct so there is no use of this method)
	/*public int getEmployeeID(String employee_name){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql="select employeeId from Employee where employee_username=:employee_name";
		Query query = session.createQuery(sql);
		  query.setString("employee_name", employee_name);
		  Object id = query.uniqueResult();;
		 int e_id=Integer.parseInt(id.toString());
		session.close();
		return e_id;
	}*/
	
	public List getEmpProjects(int employee_id){
		System.out.println("in method");
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql="from ProjectInfo where employee_id="+employee_id;
		Query query = session.createQuery(sql);
	
		  List r=query.list();
       session.close();
       return r;
	}
	   
	
	//method for inserting new entry into project tables
	public int insertProject(int employee_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Employee e1=session.get(Employee.class, employee_id);
		ProjectInfo newProject=new ProjectInfo("Team project","vrghfghdgrthgdjhu",e1);
		session.save(newProject);
		transaction.commit();
		//ProjectInfo project=session.get(ProjectInfo.class, newProject.getProjectId());
		int project_id=newProject.getProjectId();
		session.close();	
		return project_id;
	}
	   
}
