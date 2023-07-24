package ksh;

public class Permanent extends Employees {

	public Permanent(String empNo, String ename, String deptName, int salary) {
		super(empNo, ename, deptName, salary);
	}

	@Override
	public void paidSalary() {
		super.setSalary(getSalary());
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
