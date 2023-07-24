package ksh;

public class RemoteControll {
	private TV tv;

	public RemoteControll() {
		this.tv = new TV("삼송");
	}
	
	public void powerOnTV() {
		this.tv.powerOn();
	}
	

}
