package com.evaluation.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.evaluation.persistence.HibernateUtil;
import com.evaluation.pojo.Employee;
import com.evaluation.pojo.IterationInfo;
import com.evaluation.pojo.ProjectInfo;
import com.evaluation.pojo.ReleaseInfo;
import com.mysql.jdbc.Statement;

/**
 * Hello world! Use rest Controller here of spring
 */

public class ReleaseDao {
	public final Logger logger = Logger.getLogger(ReleaseDao.class.getName());
	
	ProjectInfo project;
	Employee e;
	//method for fetching release list
	public List getReleaseList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List r = session.createQuery("FROM ReleaseInfo").list();
		session.close();
		return r;
	}
	
	//method for fetching releases regarding project
	public List getRelease(int release_project){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql="select * from release_info where release_project="+release_project+" and release_active=1";
		SQLQuery q= session.createSQLQuery(sql);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List releaseList=q.list();
		project=session.get(ProjectInfo.class,release_project);
		System.out.println(project.getProjectId());
		e=session.get(Employee.class,project.getEmployee().getEmployeeId());
		System.out.println(e.getEmployeeId());
		System.out.println(project);
		
		session.close();
	     return releaseList;
	     
	}
	//method for inserting the new release
	public void insertRelease() throws ParseException{
		
		
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			
			
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date d1 = df.parse("02-7-2016"); // for example, today's date
			Date d2 = df.parse("21-7-2016"); // use your own dates, of course
			//public ReleaseInfo(int releaseId, ProjectInfo project, String releaseTitle, String releaseDescription,
			//Date releaseStartDate, Date releasePlanneDdate, Date actualReleaseDate, String releaseType,
			//String releaseTo, String releaseStatus, Employee projemployee, String releaseVersion)
			ReleaseInfo newRelease=new ReleaseInfo( project, "inserted release title", "inserted release desc", d1, d2, d2, "milestone", "QA", "working", e, "v1.0.0.2");
			System.out.println(newRelease.getReleaseId());
			session.save(newRelease);
			transaction.commit();
			session.close();	
		}
	
	//method for deleting the item
	
	public void deletinRelease(int release_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		ReleaseInfo newRelease=session.get(ReleaseInfo.class,release_id);
		session.delete(newRelease);
		transaction.commit();
		session.close();	
	}
	
	

}