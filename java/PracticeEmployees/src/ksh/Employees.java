package ksh;

public abstract class Employees {

	private String empNo;
	private String ename;
	private String deptName;
	private int salary;
	
	public Employees(String empNo, String ename, String deptName, int salary) {
		this.empNo = empNo;
		this.ename = ename;
		this.deptName = deptName;
		this.salary = salary;
	}
	
	
	
	
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public abstract void paidSalary();
	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", ename=" + ename + ", deptName="
				+ deptName + ", salary=" + salary + "]";
	}
	
	
	
}
