package com.evaluation.Dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import com.evaluation.persistence.HibernateUtil;
import com.evaluation.pojo.Employee;
import com.evaluation.pojo.EmployeeRoles;

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
		//EmployeeRoles empRole=session.get(EmployeeRoles.class,emp.getEmployeeRoleId());
		//Employee emp1=new Employee(emp.getEmployeeId(),emp.getEmployeeRoleId().toString());
		session.close();
		return emp;
		}
		catch(Exception e){
			logger.info("Employee not found");
			return null;
		}
	}
}
