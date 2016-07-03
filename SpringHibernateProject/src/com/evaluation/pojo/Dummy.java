package com.evaluation.pojo;

public class Dummy {
String userName;
String password;
int empId;
String empRole;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpRole() {
	return empRole;
}
public void setEmpRole(String empRole) {
	this.empRole = empRole;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Dummy() {
	super();
	// TODO Auto-generated constructor stub
}
public Dummy(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
@Override
public String toString() {
	return "Dummy [userName=" + userName + ", password=" + password + ", empId=" + empId + ", empRole=" + empRole + "]";
}



}
