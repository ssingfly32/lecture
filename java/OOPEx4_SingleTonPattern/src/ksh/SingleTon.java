package ksh;

// 싱글톤 : 단 하나의 객체만이 만들어지도록 하는 패턴
public class SingleTon {
//	1) static 하고 현재 클래스 타입의 변수를 만든다
	private static SingleTon instance;
	
//	2) private한 기본 생성자를 만든다. 단 생성자에선 아무것도 하지 않는다.
	private SingleTon() {
		
	}
//	3) public하고, 현재 타입의 객체를 반환하는 메서드를 만든다
	public static SingleTon getInstance() {
		if(instance == null) {
			instance = new SingleTon(); // 객체 생성
		}
		return instance;
	}
}
