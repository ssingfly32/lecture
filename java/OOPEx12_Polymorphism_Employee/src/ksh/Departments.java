package ksh;

import java.util.ArrayList;

public class Departments {

	private int deptNo;
	private String deptName;
	private ArrayList<Employees> empList;
	
	public Departments(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.empList = new ArrayList<Employees>(); // 객체 생성
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

//	이것도 다형성
	public void getEmpList() {
		for(Employees e : this.empList) {
			System.out.println(e.toString());
		}
	}

	public void addEmployees(Employees e) {
		this.empList.add(e);
	}

	public int getDeptNo() {
		return deptNo;
	}

	@Override
	public String toString() {
		return "Departments [deptNo=" + deptNo + ", deptName=" + deptName
				+ ", empList=" + empList + "]";
	}
	
	
}
