package ksh;

public class ThreadTest {

	public static void main(String[] args) {
		// 스레드 생성 방법
		// 1) java.lang.Thread를 상속받아 구현해보자
		ThreadEx th1 = new ThreadEx("스레드 1");
		// 2) Runnable 인터페이스로 구현한 스레드
		ThreadRunnable th2 = new ThreadRunnable(); // runnable 객체
		
		// 스레드의 우선순위를 조정 가능
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		new Thread(th2).start(); //th2실행
		th1.start(); // run() 메소드 안에 있는 코드가 실행됨.
		
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ", i :  " + i);
		}
		
	}

}

class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		for (int i=0; i<50; i++) {
			System.out.println(Thread.currentThread().getName() + ", i :  " + i);
		}		
	}
	
}

class ThreadEx extends Thread {

	public ThreadEx(String name) {
		super(name);
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(this.getName() + ", i :  " + i);
		}
	}
	
}