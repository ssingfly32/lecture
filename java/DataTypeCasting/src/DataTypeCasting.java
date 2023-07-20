
public class DataTypeCasting {
	public static void main(String[] args) {
		byte b = 123;
		System.out.println(b);
		
//		묵시적 형변환 : 프로그래머가 형 변환 연산자를 쓰지 않더라도 자동으로 되는 형변환
//		보통, 작은 타입에서 큰 타입으로 변할 때 묵시적 형 변환이 일어난다.
		int i = b;
		System.out.println(i);
		
//		명시적 형 변환 : 프로그래머가 형 변환을 하라고 명시해 놓는것. (큰 타입 -> 작은 타입)
//		(형변환할 데이터 타입) 캐스팅 할 변수;		
		double pi = 3.141592;
//		float fPi = pi; (에러 : 큰 타입에서 작은 타입으로 데이터 형변환을 묵시적으로 하지 못한다.)
		float fPi = (float)pi; // 명시적 형 변환
		
		int i2 = 32767;
		short s = (short)i2;
		System.out.println(s);
		
		int i3 = 32768;
		short s2 = (short)i3;
		System.out.println(s2); // -32768 (overflow현상)
		
		char c = 'a';
		System.out.println(c);
		System.out.println((int)c); // 문자는 내부적으로 ascii 코드값으로 되어 있고, 그 값이 정수로 바뀐다.
		
	}
}
