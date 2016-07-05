package com.releasemanagement.pojo;

import javax.persistence.*;

@Entity
@Table(name = "employee_roles")
public class EmployeeRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@SequenceGenerator(name = "role_seq",initialValue = 1)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_def", unique = true, nullable = false)
	private String roleDefinition;

	
	public EmployeeRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRoles(int roleId, String roleDefinition) {
		super();
		this.roleId = roleId;
		this.roleDefinition = roleDefinition;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDefinition() {
		return roleDefinition;
	}

	public void setRoleDefinition(String roleDefinition) {
		this.roleDefinition = roleDefinition;
	}

	
}
