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

	public  final Logger logger = Logger.getLogger(ReleaseDao.class.getName());	
	Employee e;
	//method for fetching all the list of project
	public List getProjectList(){
		   		Session session = HibernateUtil.getSessionFactory().openSession();
		   		List r=session.createQuery("FROM ProjectInfo").list();
		       session.close();
		   return r;
	   }
	//method for fetching the employee id
	public int getEmployeeID(String employee_name){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql="select employeeId from Employee where employee_username=:employee_name";
		Query query = session.createQuery(sql);
		  query.setString("employee_name", employee_name);
		  Object id = query.uniqueResult();;
		 int e_id=Integer.parseInt(id.toString());
		 System.out.println(e_id);
		 String sql1=" from Employee where employee_id="+e_id;
		Query q = session.createQuery(sql1);
		List emp=q.list();
		for (Object object : emp) {
			 e=(Employee)object;
		}
			session.close();
		return e_id;
	}
	
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
	public void insertProject(){

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		ProjectInfo newProject=new ProjectInfo("Team project","vrghfghdgrthgdjhu",e);

		System.out.println(e.getEmployeeId());
		session.save(newProject);
		transaction.commit();
		session.close();	
	}
	   
}
