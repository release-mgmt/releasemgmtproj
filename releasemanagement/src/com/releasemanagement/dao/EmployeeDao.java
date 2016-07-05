package com.releasemanagement.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.releasemanagement.persistence.HibernateUtil;
import com.releasemanagement.pojo.Employee;

public class EmployeeDao {
	public final Logger logger = Logger.getLogger(EmployeeDao.class.getName());
	Employee emp;

	/// method for authenticating employee
	public Employee authenticateUser(String user_name, String password) {
		//PropertyConfigurator.configure("log4j.properties");
		
		try{
			logger.info("Employee found");
		Session session = HibernateUtil.getSessionFactory().openSession();
		 String sql="FROM Employee where employee_username=:user_name and employee_password=PASSWORD("+password+")";
		Query query = session.createQuery(sql);
		query.setString("user_name", user_name);
		emp = (Employee) query.uniqueResult();
		logger.info(emp.toString());
		session.close();
		return emp;
		}
		catch(Exception e){
			logger.info("Employee not found");
			return null;
		}
	}
}
