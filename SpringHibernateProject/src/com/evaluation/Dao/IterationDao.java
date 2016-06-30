package com.evaluation.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.evaluation.persistence.HibernateUtil;
import com.evaluation.pojo.Employee;
import com.evaluation.pojo.ItemsInfo;
import com.evaluation.pojo.IterationInfo;
import com.evaluation.pojo.ProjectInfo;
import com.evaluation.pojo.ReleaseInfo;

public class IterationDao {
	ReleaseInfo r;
	//method for fetching  all iterations
	public List iterationList(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();	 
		List i=session.createQuery("FROM IterationInfo").list();
        session.close();
        return i;
	}
	
	
	//method for fetching iterations relatd to releaseID
	
	public List releaseIterations(int release_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql="select * from iteration_info where iteration_for_release="+release_id;
		SQLQuery q= session.createSQLQuery(sql);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List iterations=q.list();
		String sql1=" from ReleaseInfo where release_id="+release_id;
		r=session.get(ReleaseInfo.class,release_id);
		System.out.println(r);
		session.close();
	     return iterations;
	}
	
	//method for inserting the new iteration
	public void insertIteration() throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		
		//ProjectInfo newProject=new ProjectInfo("Team project","vrghfghdgrthgdjhu",e);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 = df.parse("02-7-2016"); // for example, today's date
		Date d2 = df.parse("21-7-2016"); // use your own dates, of course
		IterationInfo newIteration=new IterationInfo( r, "acb", "asdfhsdf", d1, d2, "working", "QA");
		System.out.println(r.getReleaseId());
		session.save(newIteration);
		transaction.commit();
		session.close();	
	}
	
	//method for deleting the item
	
	public void deletinIteration(int iteration_id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		IterationInfo newIteration=session.get(IterationInfo.class,iteration_id);
		session.delete(newIteration);
		transaction.commit();
		session.close();	
	}
	
}
