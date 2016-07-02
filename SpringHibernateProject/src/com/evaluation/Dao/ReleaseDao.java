package com.evaluation.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
		String sql="select * from release_info where release_project="+release_project;
		SQLQuery q= session.createSQLQuery(sql);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List releaseList=q.list();
		project=session.get(ProjectInfo.class,release_project);
		e=session.get(Employee.class,project.getEmployee().getEmployeeId());
		if(releaseList.isEmpty()){
			logger.info("New List is inerting");
			
		}
		session.close();
	     return releaseList;
	     
	}
	
	//mwthod for getting releases as per serach criteria
	public List gettingReleases(String searchCriteria,String key){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List releaseList=null;
		String query;
		SQLQuery q;
		
		switch(searchCriteria){
		case "type":
			query="select * from release_info where release_type=:key";
			 q=session.createSQLQuery(query);
			 q.setString("key", key);
			 releaseList=q.list();
			 break;
		case "status":
			query="select * from release_info where release_status=:key";
			 q=session.createSQLQuery(query);
			 q.setString("key", key);
			 releaseList=q.list();
			break;
			
		case "title":
			query="select * from release_info where release_title=:key";
			 q=session.createSQLQuery(query);
			 q.setString("key", key);
			 releaseList=q.list();
			break;
			
		}
	
		session.close();
		return releaseList;
	}
	
	//method for seraching the releases by date
	public List getReleaseByDate(String startDate,String endDate) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		//changing the forma of date
		DateFormat originalFormat = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
	    DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
	    Date date1 = originalFormat.parse(startDate);
	    Date date2=originalFormat.parse(endDate);
	    String s_Date = targetFormat.format(date1);
	    String e_Date=targetFormat.format(date2);
		List releaseList=null;
		String query="select * from release_info where release_startdate BETWEEN "+"'"+s_Date+"'"+" AND "+"'"+e_Date+"'"+" or release_actualreleasedate BETWEEN "+"'"+s_Date+"'"+" AND "+"'"+e_Date+"'";
					//select * from release_info where release_startdate BETWEEN     ' 2017-08-06 '    AND     '2017-10-06'    or release_actualreleasedate BETWEEN    '2017-08-06   '    AND    ' 2017-10-06 ';
		SQLQuery q=session.createSQLQuery(query);
		 releaseList=q.list();
		 return releaseList;
	}
	
	//method for inserting the new release
	public int insertRelease(int project_id) throws ParseException{

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date d1 = df.parse("02-7-2016"); // for example, today's date
			Date d2 = df.parse("21-7-2016"); // use your own dates, of course
			ProjectInfo project1=session.get(ProjectInfo.class ,project_id);
			e=session.get(Employee.class,project1.getEmployee().getEmployeeId());
			ReleaseInfo newRelease=new ReleaseInfo( project1, "inserted release title", "inserted release desc", d1, d2, d2, "milestone", "QA", "working", e, "v1.0.0.2");
			System.out.println(newRelease.getReleaseId());
			session.save(newRelease);
			transaction.commit();
			session.close();	
			return newRelease.getReleaseId();
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