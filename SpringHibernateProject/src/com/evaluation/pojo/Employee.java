package com.evaluation.pojo;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "employee_info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "employee_fname")
	private String employeeFname;

	@Column(name = "employee_lname")
	private String employeeLname;

	@Column(name = "employee_designation")
	private String employeeDesignation;
	
	@Column(name = "employee_username")
	private String employeeUsername;
	
	@Column(name = "employee_password")
	private String employeePassword;

	@OneToOne
	@JoinColumn(name = "employee_role",referencedColumnName="role_id",nullable=false)
	private EmployeeRoles employeeRoleId;
	
	@OneToMany(mappedBy = "employee",fetch=FetchType.EAGER)
	//@JsonManagedReference("project_info")
	@JsonIgnore
	private List<ProjectInfo> project;
	
	@OneToMany(mappedBy = "projemployee",fetch=FetchType.EAGER)
	//@JsonManagedReference("project_info")
	@JsonIgnore
	private List<ReleaseInfo> projEpmInfo;

	
	
	



	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFname() {
		return employeeFname;
	}

	public void setEmployeeFname(String employeeFname) {
		this.employeeFname = employeeFname;
	}

	public String getEmployeeLname() {
		return employeeLname;
	}

	public void setEmployeeLname(String employeeLname) {
		this.employeeLname = employeeLname;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public EmployeeRoles getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(EmployeeRoles employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public List<ProjectInfo> getProject() {
		return project;
	}

	public void setProject(List<ProjectInfo> project) {
		this.project = project;
	}

	public List<ReleaseInfo> getProjEpmInfo() {
		return projEpmInfo;
	}

	public void setProjEpmInfo(List<ReleaseInfo> projEpmInfo) {
		this.projEpmInfo = projEpmInfo;
	}

	
	
}
