package ksh;

public class PartTimer extends Employees {
	private int workTime;
	private int payPerHour;

	
	public PartTimer(String empNo, String ename, String deptName,
			int workTime, int payPerHour) {
		super(empNo, ename, deptName,0);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
		this.paidSalary();
	}


	@Override
	public void paidSalary() {
		super.setSalary(this.payPerHour*this.workTime);
	}


	@Override
	public String toString() {
		return super.toString() + "PartTimer [workTime=" + workTime + ", payPerHour=" + payPerHour
				+ "]";
	}
	
	

}
