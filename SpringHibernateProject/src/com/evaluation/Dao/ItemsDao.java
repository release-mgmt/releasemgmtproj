package com.evaluation.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.evaluation.persistence.HibernateUtil;
import com.evaluation.pojo.ItemsInfo;
import com.evaluation.pojo.IterationInfo;
import com.evaluation.pojo.ProjectInfo;
import com.evaluation.pojo.ReleaseInfo;

public class ItemsDao {
	public final Logger logger = Logger.getLogger(EmployeeDao.class.getName());
	IterationInfo iteration;
	ReleaseInfo release;
	//method for fetching  all iterations
		public List itemList(){
			
			Session session = HibernateUtil.getSessionFactory().openSession();	 
			List i=session.createQuery("FROM ItemsInfo").list();
	        session.close();
	        return i;
		}
		
		
		//method for fetching iterations relatd to releaseID
		
		public List iterationItemList(int iteration_id){
			try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			String sql="select * from item_info where item_for_iteration="+iteration_id;
			SQLQuery q= session.createSQLQuery(sql);
			q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List items=q.list();
			//logging the item information
			if(items.isEmpty()){
			logger.info(q.toString());
			logger.info("Items not found");
			}
			
			session.close();
		     return items;
		     }catch(Exception e){
		    	 logger.warn(e);
		    	 
		    	 return null;
		     }
			
		}


		//method for inserting the new item
		public int insertItem(int iteration_id){

				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction transaction=session.beginTransaction();
				iteration = session.get(IterationInfo.class,iteration_id);
				release=session.get(ReleaseInfo.class, iteration.getRelease().getReleaseId());
				iteration.setRelease(release);
				ItemsInfo newItem=new ItemsInfo( "inserted item title", "inserted item desc",0,release,iteration);
				System.out.println(iteration.getIterationId());
				System.out.println(iteration.getRelease());
				session.save(newItem);
				transaction.commit();
				session.close();
				return newItem.getItemId();
			}
		
		//method for deleting the item
		
		public void deletinItem(int item_id){
			/*try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			ItemsInfo newItem=session.get(ItemsInfo.class,item_id);
			if(newItem!=null){
			logger.info(newItem.toString());
			session.delete(newItem);
			transaction.commit();
			session.close();
			return "Item deleted";
			}else{
				return null;
			}
			}catch(Exception e){
				logger.info(e);
			}*/
		}
		
		
}
