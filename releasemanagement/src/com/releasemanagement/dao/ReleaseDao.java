package com.releasemanagement.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.releasemanagement.persistence.HibernateUtil;
import com.releasemanagement.pojo.Employee;
import com.releasemanagement.pojo.ProjectInfo;
import com.releasemanagement.pojo.ReleaseInfo;

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
	public List<ReleaseInfo> getRelease(int release_project) {
		try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "from ReleaseInfo where release_project=" + release_project;
		Query query = session.createQuery(sql);

		List<ReleaseInfo> releaseList = query.list();
		project = session.get(ProjectInfo.class, release_project);
		e = session.get(Employee.class, project.getEmployee().getEmployeeId());
		if (releaseList.isEmpty()) {
			logger.info("New List is inerting");
		}
		session.close();
		return releaseList;
		}catch(Exception e){
			logger.info(e.getMessage());
			return null;
		}
	}

	public ReleaseInfo getReleaseFullInfo(int projectId, int releaseId) {
		try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		String sql = "from ReleaseInfo where release_project=" + projectId + "and release_id=" + releaseId;
		Query query = session.createQuery(sql);
		ReleaseInfo releaseList = (ReleaseInfo) query.uniqueResult();
		session.close();
		return releaseList;
		}
		catch(Exception e){
			logger.info(e.getMessage());
			return null;
		}
	}

	public List gettingReleasesBySearch(String searchCriteria, String key) {
		try
		{
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
		
		}catch(Exception e){
			logger.info(e.getMessage());
			return null;
		}
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
	public int insertRelease(int project_id, ReleaseInfo r) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();

			ProjectInfo project1 = session.get(ProjectInfo.class, project_id);
			e = session.get(Employee.class, project1.getEmployee().getEmployeeId());

			System.out.println(project1.getProjectId());
			System.out.println(e.getEmployeeId());

			System.out.println(r.getReleasePlanneDdate());

			ReleaseInfo newRelease = new ReleaseInfo(project1, r.getReleaseTitle(), r.getReleaseDescription(),
					r.getReleaseStartDate(), r.getReleasePlanneDdate(), r.getActualReleaseDate(), r.getReleaseType(),
					r.getReleaseTo(), r.getReleaseStatus(), e, r.getReleaseVersion());

			System.out.println(newRelease.getReleaseId());
			session.save(newRelease);
			transaction.commit();
			session.close();
			return newRelease.getReleaseId();
		} catch (Exception parseError) {
			parseError.printStackTrace();
			logger.info("Parsing error of date while inserting the data using dates");
			logger.debug(parseError);
			return 0;
		}
	}

	// method for deleting the item
	public String deletinRelease(int release_id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();
			ReleaseInfo newRelease = session.get(ReleaseInfo.class, release_id);
			session.delete(newRelease);
			transaction.commit();
			session.close();
			return "deleted";
		} catch (Exception e) {
			return " not deleted";
		}

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

		String updatedType = release.getReleaseType().toLowerCase();
		if (updatedType.equals("final")) {
			updatedVersion = existingVersion + ".Final";
		} else {
			versionArray = existingVersion.split("\\.");
			String stringData;
			int numberOnly;
			if (updatedType.equals("milestone")) {
				System.out.println("release type MileStone found");
				stringData = versionArray[0];
				numberOnly = Integer.parseInt(stringData.replaceAll("[^0-9]", ""));
				numberOnly++;

				stringData = "v" + new Integer(numberOnly).toString();

				versionArray[0] = stringData;
			} else if (updatedType.equals("major")) {
				System.out.println("release type Major found");
				stringData = versionArray[1];
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				stringData = new Integer(numberOnly).toString();
				versionArray[1] = stringData;
			} else if (updatedType.equals("minor")) {
				System.out.println("release type Minor found");
				stringData = versionArray[2];
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				stringData = new Integer(numberOnly).toString();
				versionArray[2] = stringData;
			} else if (updatedType.equals("build")) {
				System.out.println("release type Build found");
				stringData = versionArray[3];
				System.out.println("version array 3:" + versionArray[3]);
				numberOnly = Integer.parseInt(stringData);
				numberOnly++;
				System.out.println("incremented number : " + numberOnly);
				stringData = new Integer(numberOnly).toString();
				versionArray[3] = stringData;
			} else if (updatedType.equals("final")) {
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