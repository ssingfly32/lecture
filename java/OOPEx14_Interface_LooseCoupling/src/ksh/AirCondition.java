package ksh;

public class AirCondition implements ElectricDevice {

	@Override
	public void powerOn() {
		System.out.println(this.toString() + "이 켜집니다");
	}

}
