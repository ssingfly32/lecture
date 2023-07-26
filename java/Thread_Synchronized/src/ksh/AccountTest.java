package ksh;

public class AccountTest {

	public static void main(String[] args) {
		Account acc = new Account();
		
		Family 아빠 = new Family("아빠", acc);
		Family 엄마 = new Family("엄마", acc);
		Family 나 = new Family("나", acc);

		Thread fTh = new Thread(아빠);
		Thread mTh = new Thread(엄마);
		Thread iTh = new Thread(나);

		mTh.start();
		iTh.start();
		fTh.start();
		
	}

}
