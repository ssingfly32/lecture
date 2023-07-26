package ksh;

public class Family implements Runnable {
	private String name;
	private Account acc; // 가족은 가족통장을 가지고 있다. 
	
	

	public Family(String name, Account acc) {
		super();
		this.name = name;
		this.acc = acc;
	}


	// 가족들이 인출을 각각 해야 하는 구조를 프로그래밍 하기 위해 스레드 객체로 만든다.
	@Override
	public void run() {
		while(this.acc.getBalance() > 0) {
			// 1 ~ 100000를 랜덤하게 인출
			int money = (int)(Math.round((Math.random() * 100000 + 1) * 100) / 100);
			
			if(this.acc.withDraw(money)) { // 인출이 되었다면..
				System.out.println(this.name + "가" + money + "원을 인출 했습니다. 잔액 :"
						+ this.acc.getBalance());
			}
		}
	}

}
