package ksh;

public class PartTimer extends Employees {
	private int workTime;
	private int payPerHour;

	public PartTimer(String empNo, String empName, int deptNo, int workTime, int payPerHour) {
		super(empNo, empName, deptNo,0);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
		this.paidSalary();
	}

	
	public int getWorkTime() {
		return workTime;
	}


	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}


	public int getPayPerHour() {
		return payPerHour;
	}


	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}


	@Override
	public void paidSalary() {
		super.setSalary(this.workTime*this.payPerHour);
	}
	
	


	@Override
	public String toString() {
		return super.toString() + "PartTimer [workTime=" + workTime + ", payPerHour=" + payPerHour
				+ "]";
	}
	
	

}
