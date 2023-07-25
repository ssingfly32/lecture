package ksh;

public class RemoteConTest {

	public static void main(String[] args) {
		TV tv = new TV("LG");
		
		RemoteControl remocon = new RemoteControl();
		remocon.remoteControl(tv);
		
		AirCondition air = new AirCondition();
		remocon.remoteControl(air);
		
	}

}
