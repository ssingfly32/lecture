package ksh;

public class TV {
	private String brandName;

	public TV(String brandName) {
		super();
		this.brandName = brandName;
	}
	
	public void powerOn() {
		System.out.println(this.brandName + "TV가 켜집니다");
	}
}
