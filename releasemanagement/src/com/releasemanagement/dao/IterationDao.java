package com.releasemanagement.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.releasemanagement.persistence.HibernateUtil;
import com.releasemanagement.pojo.IterationInfo;
import com.releasemanagement.pojo.ReleaseInfo;

public class IterationDao {
	public final Logger logger = Logger.getLogger(IterationDao.class.getName());
	ReleaseInfo r;

	// method for fetching all iterations
	public List iterationList() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List i = session.createQuery("FROM IterationInfo").list();
		session.close();
		return i;
	}

	// method for fetching iterations relatd to releaseID

	public List releaseIterations(int release_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from iteration_info where iteration_for_release=" + release_id;
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List iterations = q.list();
		return iterations;
	}

	// method for getting iterations as per serach criteria
	public List gettingIterationBySearch(String searchCriteria, String key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List releaseList = null;
		String query;
		SQLQuery q;

		switch (searchCriteria) {
		case "type":
			query = "select * from iteration_info where iteration_type=:key";
			q = session.createSQLQuery(query);
			q.setString("key", key);
			releaseList = q.list();
			break;
		case "status":
			query = "select * from iteration_info where iteration_status=:key";
			q = session.createSQLQuery(query);
			q.setString("key", key);
			releaseList = q.list();
			break;
		}

		session.close();
		return releaseList;
	}

	// method for seraching the iteration by date
	public List getIterationByDate(String startDate, String endDate) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// changing the format of date
			DateFormat originalFormat = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
			DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date date1 = originalFormat.parse(startDate);
			Date date2 = originalFormat.parse(endDate);
			String s_Date = targetFormat.format(date1);
			String e_Date = targetFormat.format(date2);
			List releaseList = null;
			String query = "select * from iteration_info where iteration_startdate BETWEEN " + "'" + s_Date + "'"
					+ " AND " + "'" + e_Date + "'" + " or iteration_enddate BETWEEN " + "'" + s_Date + "'" + " AND "
					+ "'" + e_Date + "'";

			SQLQuery q = session.createSQLQuery(query);
			releaseList = q.list();
			return releaseList;
		} catch (ParseException parseError) {
			logger.info("Error while parsing the dates while fetching the data using dates");
			logger.debug(parseError);

			return null;
		}
	}

	// method for inserting the new iteration
	public int insertIteration(int release_id,IterationInfo it) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date d1 = df.parse("02-7-2016"); // for example, today's date
			Date d2 = df.parse("21-7-2016"); // use your own dates, of course
			r = session.get(ReleaseInfo.class, release_id);
			//IterationInfo newIteration = new IterationInfo(r, "acb", "asdfhsdf", d1, d2, "working", "QA");
			IterationInfo newIteration = new IterationInfo(r, it.getIterationTitle(),it.getIterationDescription() ,it.getIterationStartDate(), it.getIterationEndDate(),it.getIterationStatus(), it.getIterationType());
			System.out.println(r.getReleaseId());
			session.save(newIteration);
			transaction.commit();
			session.close();
			return newIteration.getIterationId();
		} catch (ParseException parseError) {
			logger.info("parsing error while inserting the interation");
			logger.debug(parseError);
			return 0;
		}
	}

	// method for deleting the item

	public void deletinIteration(int iteration_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		IterationInfo newIteration = session.get(IterationInfo.class, iteration_id);
		session.delete(newIteration);
		transaction.commit();
		session.close();
	}

	// method for updating existing iteration into tables
	public String updateIteration(IterationInfo iteration) {

		// id will be receieved from view part on submit
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		IterationInfo iter = session.load(IterationInfo.class, new Integer(iteration.getIterationId()));
		try {
			transaction.begin();
			// while updating , updated and non updated value will be returned
			// and a whole new object will be received from view part in jason
			iter.setIterationDescription(iteration.getIterationDescription());
			iter.setIterationEndDate(iteration.getIterationEndDate());
			iter.setIterationStartDate(iteration.getIterationStartDate());
			iter.setIterationStatus(iteration.getIterationStatus());
			iter.setIterationTitle(iteration.getIterationTitle());
			iter.setIterationType(iteration.getIterationType());
			transaction.commit();
			return "update successful";
		} catch (Exception e) {

			transaction.rollback();
			return "update failure";
		}

	}

}
