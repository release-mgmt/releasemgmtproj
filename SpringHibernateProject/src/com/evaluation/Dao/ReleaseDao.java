package com.evaluation.Dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
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
	public final Logger logger = Logger.getLogger(IterationDao.class.getName());

	ProjectInfo project;
	Employee e;

	// method for fetching release list
	public List<ReleaseInfo> getReleaseList() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ReleaseInfo> r = session.createQuery("FROM ReleaseInfo").list();
		session.close();
		return r;
	}

	// method for fetching releases regarding project
	public List getRelease(int release_project) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "select * from release_info where release_project=" + release_project;
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List releaseList = q.list();
		project = session.get(ProjectInfo.class, release_project);
		e = session.get(Employee.class, project.getEmployee().getEmployeeId());
		if (releaseList.isEmpty()) {
			logger.info("New List is inerting");

		}
		session.close();
		return releaseList;

	}

	// mwthod for getting releases as per serach criteria
	public List gettingReleasesBySearch(String searchCriteria, String key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List releaseList = null;
		String query;
		SQLQuery q;

		switch (searchCriteria) {
		case "type":
			query = "select * from release_info where release_type=:key";
			q = session.createSQLQuery(query);
			q.setString("key", key);
			releaseList = q.list();
			break;
		case "status":
			query = "select * from release_info where release_status=:key";
			q = session.createSQLQuery(query);
			q.setString("key", key);
			releaseList = q.list();
			break;

		case "title":
			query = "select * from release_info where release_title=:key";
			q = session.createSQLQuery(query);
			q.setString("key", key);
			releaseList = q.list();
			break;

		}

		session.close();
		return releaseList;
	}

	// method for seraching the releases by date
	public List getReleaseByDate(String startDate, String endDate) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// changing the forma of date
			DateFormat originalFormat = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
			DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date date1 = originalFormat.parse(startDate);
			Date date2 = originalFormat.parse(endDate);
			String s_Date = targetFormat.format(date1);
			String e_Date = targetFormat.format(date2);
			List releaseList = null;
			String query = "select * from release_info where release_startdate BETWEEN " + "'" + s_Date + "'" + " AND "
					+ "'" + e_Date + "'" + " or release_actualreleasedate BETWEEN " + "'" + s_Date + "'" + " AND " + "'"
					+ e_Date + "'";
			// select * from release_info where release_startdate BETWEEN '
			// 2017-08-06 ' AND '2017-10-06' or release_actualreleasedate
			// BETWEEN '2017-08-06 ' AND ' 2017-10-06 ';
			SQLQuery q = session.createSQLQuery(query);
			releaseList = q.list();
			return releaseList;
		} catch (ParseException parseError) {
			logger.info("date parsing error occured while fetching the releases by dates ");
			logger.debug(parseError);
			return null;
		}
	}

	// method for inserting the new release
	public int insertRelease(int project_id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date d1 = df.parse("02-7-2016"); // for example, today's date
			Date d2 = df.parse("21-7-2016"); // use your own dates, of course
			ProjectInfo project1 = session.get(ProjectInfo.class, project_id);
			e = session.get(Employee.class, project1.getEmployee().getEmployeeId());
			ReleaseInfo newRelease = new ReleaseInfo(project1, "inserted release title", "inserted release desc", d1,
					d2, d2, "milestone", "QA", "working", e, "v1.0.0.2");
			System.out.println(newRelease.getReleaseId());
			session.save(newRelease);
			transaction.commit();
			session.close();
			return newRelease.getReleaseId();
		} catch (ParseException parseError) {
			logger.info("Parsing error of date while inserting the data using dates");
			logger.debug(parseError);
			return 0;
		}
	}

	// method for deleting the item
	public void deletinRelease(int release_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ReleaseInfo newRelease = session.get(ReleaseInfo.class, release_id);
		session.delete(newRelease);
		transaction.commit();
		session.close();
	}

	// method for updating the release information
	// method for updating existing release into tables
	public String updateRelease(ReleaseInfo release) {

		// id will be receieved from view part on submit
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		ReleaseInfo rel = session.load(ReleaseInfo.class, new Integer(release.getReleaseId()));
		String existingVersion = rel.getReleaseVersion();
		System.out.println("existing version:" + existingVersion);
		String[] versionArray;

		String updatedVersion;
		if (release.getReleaseType().contains("Final")) {
			updatedVersion = existingVersion + ".Final";
		} else {
			versionArray = existingVersion.split("\\.");
			String stringData;
			int numberOnly;
			if (release.getReleaseType().contains("MileStone")) {
				System.out.println("release type MileStone found");
				stringData = versionArray[0];
				numberOnly = Integer.parseInt(stringData.replaceAll("[^0-9]", ""));
				numberOnly++;

				stringData = "v" + new Integer(numberOnly).toString();

				versionArray[0] = stringData;
			} else if (release.getReleaseType().contains("Major")) {
				System.out.println("release type Major found");
				stringData = versionArray[1];
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				stringData = new Integer(numberOnly).toString();
				versionArray[1] = stringData;
			} else if (release.getReleaseType().contains("Minor")) {
				System.out.println("release type Minor found");
				stringData = versionArray[2];
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				stringData = new Integer(numberOnly).toString();
				versionArray[2] = stringData;
			} else if (release.getReleaseType().contains("Build")) {
				System.out.println("release type Build found");
				stringData = versionArray[3];
				System.out.println("version array 3:" + versionArray[3]);
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				System.out.println("incremented number : " + numberOnly);
				stringData = new Integer(numberOnly).toString();
				versionArray[3] = stringData;
			} else if (release.getReleaseType().contains("Final")) {
				System.out.println("release type Final found");

			} else {
				System.out.println("no release Type found...");
			}
			updatedVersion = versionArray[0] + "." + versionArray[1] + "." + versionArray[2] + "." + versionArray[3];

			System.out.println("updated version :" + updatedVersion);

		}

		try {

			transaction.begin();

			// while updating , updated and non updated value will be returned
			// and a whole new object will be received from view part in jason

			rel.setActualReleaseDate(release.getActualReleaseDate());
			rel.setReleaseDescription(release.getReleaseDescription());
			rel.setReleasePlanneDdate(release.getReleasePlanneDdate());
			rel.setReleaseStartDate(release.getReleaseStartDate());
			rel.setReleaseStatus(release.getReleaseStatus());
			rel.setReleaseTitle(release.getReleaseTitle());
			rel.setReleaseTo(release.getReleaseTo());
			rel.setReleaseType(release.getReleaseType());
			rel.setReleaseVersion(updatedVersion);

			transaction.commit();
			return "transaction successful : versin :" + updatedVersion;
		} catch (Exception e) {

			transaction.rollback();
			return "update failure";
		}

	}

}