package ksh;

public abstract class Employees {

	private String empNo;
	private String empName;
	private int deptNo;
	private int salary;
	
	public Employees(String empNo, String empName, int deptNo, int salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.deptNo = deptNo;
		this.salary = salary;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
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
		return "Employees [empNo=" + empNo + ", empName=" + empName
				+ ", deptNo=" + deptNo + ", salary=" + salary + "]";
	}
	
	
}
