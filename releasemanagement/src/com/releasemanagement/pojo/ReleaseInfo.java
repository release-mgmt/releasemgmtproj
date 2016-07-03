package com.releasemanagement.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "release_info")
public class ReleaseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rel_seq")
	@SequenceGenerator(name = "rel_seq", initialValue = 1)
	@Column(name = "release_id")
	private int releaseId;

	@ManyToOne
	@JoinColumn(name = "release_project", referencedColumnName = "project_id")
	@JsonIgnore
	private ProjectInfo project;

	@Column(name = "release_title", unique = true, nullable = false)
	private String releaseTitle;

	@Column(name = "release_description", columnDefinition = "VARCHAR(1024)")
	private String releaseDescription;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_startdate", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date releaseStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_planneddate", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date releasePlanneDdate;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_actualreleasedate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date actualReleaseDate;

	@Column(name = "release_type")
	private String releaseType;

	@Column(name = "release_under")
	private String releaseTo;

	@Column(name = "release_status")
	private String releaseStatus;

	@Column(name = "release_active")
	private int releaseActive;

	@ManyToOne
	@JoinColumn(name = "release_manager", referencedColumnName = "employee_id")
	@JsonIgnore
	private Employee projemployee;

	@Column(name = "release_version")
	private String releaseVersion;

	@OneToMany(mappedBy = "release", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<IterationInfo> iterationInfo;

	@OneToMany(mappedBy = "release", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ItemsInfo> itemInfo;

	public ReleaseInfo() {
		super();
	}

	public ReleaseInfo(ProjectInfo project, String releaseTitle, String releaseDescription, Date releaseStartDate,
			Date releasePlanneDdate, Date actualReleaseDate, String releaseType, String releaseTo, String releaseStatus,
			Employee projemployee, String releaseVersion) {
		super();

		this.project = project;
		this.releaseTitle = releaseTitle;
		this.releaseDescription = releaseDescription;
		this.releaseStartDate = releaseStartDate;
		this.releasePlanneDdate = releasePlanneDdate;
		this.actualReleaseDate = actualReleaseDate;
		this.releaseType = releaseType;
		this.releaseTo = releaseTo;
		this.releaseStatus = releaseStatus;
		this.projemployee = projemployee;
		this.releaseVersion = releaseVersion;
	}

	public ReleaseInfo(int releaseId, String releaseTitle, String releaseDescription, Date releaseStartDate,
			Date releasePlanneDdate, Date actualReleaseDate, String releaseType, String releaseTo, String releaseStatus,
			String releaseVersion) {

		this.releaseId = releaseId;

		this.releaseTitle = releaseTitle;
		this.releaseDescription = releaseDescription;
		this.releaseStartDate = releaseStartDate;
		this.releasePlanneDdate = releasePlanneDdate;
		this.actualReleaseDate = actualReleaseDate;
		this.releaseType = releaseType;
		this.releaseTo = releaseTo;
		this.releaseStatus = releaseStatus;

		this.releaseVersion = releaseVersion;
	}

	public int getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}

	public ProjectInfo getProject() {
		return project;
	}

	public void setProject(ProjectInfo project) {
		this.project = project;
	}

	public String getReleaseTitle() {
		return releaseTitle;
	}

	public void setReleaseTitle(String releaseTitle) {
		this.releaseTitle = releaseTitle;
	}

	public String getReleaseDescription() {
		return releaseDescription;
	}

	public void setReleaseDescription(String releaseDescription) {
		this.releaseDescription = releaseDescription;
	}

	public Date getReleaseStartDate() {
		return releaseStartDate;
	}

	public void setReleaseStartDate(Date releaseStartDate) {
		this.releaseStartDate = releaseStartDate;
	}

	public Date getReleasePlanneDdate() {
		return releasePlanneDdate;
	}

	public void setReleasePlanneDdate(Date releasePlanneDdate) {
		this.releasePlanneDdate = releasePlanneDdate;
	}

	public Date getActualReleaseDate() {
		return actualReleaseDate;
	}

	public void setActualReleaseDate(Date actualReleaseDate) {
		this.actualReleaseDate = actualReleaseDate;
	}

	public String getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public String getReleaseTo() {
		return releaseTo;
	}

	public void setReleaseTo(String releaseTo) {
		this.releaseTo = releaseTo;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public Employee getProjemployee() {
		return projemployee;
	}

	public void setProjemployee(Employee projemployee) {
		this.projemployee = projemployee;
	}

	public String getReleaseVersion() {
		return releaseVersion;
	}

	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}

	public List<IterationInfo> getIterationInfo() {
		return iterationInfo;
	}

	public void setIterationInfo(List<IterationInfo> iterationInfo) {
		this.iterationInfo = iterationInfo;
	}

	public List<ItemsInfo> getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(List<ItemsInfo> itemInfo) {
		this.itemInfo = itemInfo;
	}

}