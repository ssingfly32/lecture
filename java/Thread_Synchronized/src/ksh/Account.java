package ksh;

public class Account {
	private int balance = 1000000;

	// 잔액 확인하는 메서드
	public int getBalance() {
		return this.balance; 
	}
	
	// 인출하는 메서드
	public boolean withDraw(int money) {
		boolean result = false;
		synchronized(this) {
			
			if (this.balance >= money) { // 인출 가능할 때
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.balance -= money;
				result = true;
			}
		}
		return result;
	}
 }
