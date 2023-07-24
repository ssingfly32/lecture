package ksh;

public class Permanent extends Employees {

	public Permanent(String empNo, String empName, int deptNo, int salary) {
		super(empNo, empName, deptNo, salary);
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
