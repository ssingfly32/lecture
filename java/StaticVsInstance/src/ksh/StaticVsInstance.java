package ksh;

public class StaticVsInstance {
	
	private int iInt; // 인스턴스 변수
	private static int sInt; // static 변수

	{
		// 인스턴스 멤버들을 초기화 할 수 있는 블럭
		this.iInt = 0;
	}
	
	static {
		// static 멤버들을 초기화 할 수 있는 블럭
		sInt = 0;
	}
	
	public void acc() {
		sInt++;
		this.iInt++;
		System.out.println("no : " + this.hashCode() + ", sInt : " + 
		sInt + ", iInt : " + this.iInt );
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			StaticVsInstance svi = new StaticVsInstance();
			svi.acc();
		}
	}

}
