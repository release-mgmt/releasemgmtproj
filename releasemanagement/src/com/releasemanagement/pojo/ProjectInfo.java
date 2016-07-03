package com.releasemanagement.pojo;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "project_info")
public class ProjectInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proj_seq")
	@SequenceGenerator(name = "proj_seq", initialValue = 1)
	@Column(name = "project_id")
	private int projectId;

	@Column(name = "project_title", unique = true, nullable = false)
	private String projectTitle;

	@Column(name = "project_description", columnDefinition = "VARCHAR(1024)")
	private String projectDecription;

	@Column(name = "project_active")
	private int projectActive;

	@ManyToOne
	@JoinColumn(name = "project_under_employee", referencedColumnName = "employee_id")
	@JsonIgnore
	private Employee employee;

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ReleaseInfo> releaseInfo;

	public ProjectInfo() {
		super();
	}

	public ProjectInfo(String projectTitle, String projectDecription, Employee e) {
		System.out.println("in constructor");
		System.out.println(projectTitle);
		System.out.println(projectDecription);
		this.projectTitle = projectTitle;
		this.projectDecription = projectDecription;
		this.employee = e;

	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDecription() {
		return projectDecription;
	}

	public void setProjectDecription(String projectDecription) {
		this.projectDecription = projectDecription;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<ReleaseInfo> getReleaseInfo() {
		return releaseInfo;
	}

	public void setReleaseInfo(List<ReleaseInfo> releaseInfo) {
		this.releaseInfo = releaseInfo;
	}

}