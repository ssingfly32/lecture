package ksh;

public class TV implements ElectricDevice {

	
	private String brandName;

	public TV(String brandName) {
		super();
		this.brandName = brandName;
	}
	
	@Override
	public void powerOn() {
		{
			System.out.println(this.brandName + "TV가 켜집니다");
		}
	}

}
