package com.ksh.vo;

public class ManagerVo {
	private String fullName;
	private int employee_id;
	public ManagerVo(String fullName, int employee_id) {
		super();
		this.fullName = fullName;
		this.employee_id = employee_id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	@Override
	public String toString() {
		return "ManagerVo [fullName=" + fullName + ", employee_id=" + employee_id + "]";
	}
	
	
}
