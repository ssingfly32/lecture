package ksh2;

import ksh.Student;

public class Department {

	private int deptNo;
	private String deptName;

	public Department(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

//	setter : 프로그래밍 언어에서 매개변수로 얻어온 값을 멤버변수에 세팅하는 역할을 하는 메서드
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
		
	}
	
//	getter : 프로그래밍 언어에서 멤버변수의 값을 반환하는 역할을 하는 메서드
	public int getDeptNo() {
		return this.deptNo;
	}
	
	public String getDeptName() {
		return this.deptName;
	}
//	toString() : 객체가 가지고 있는 속성이름과 그의 값을 문자열로 반환하는 역할을 하는 메서드
	public String toString() {
		return "[" + this.getClass().getName() + "(" + this.hashCode() + ")]"
				+ "deptNo : " + this.deptNo + ", deptName : " + this.deptName;
	}
}
