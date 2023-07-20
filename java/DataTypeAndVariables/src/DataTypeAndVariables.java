
public class DataTypeAndVariables {
	public static void main(String[] args) {
		// boolean : true 또는 false 저장
		// 대입연산자 : 오른쪽의 값을 왼쪽에 저장(양쪽의 데이터 타입이 같을 때)
		boolean bool = false;
		System.out.println(bool);
		
		// char : 1 문자를 저장할 수 있다. 2byte.
		char character = 'a'; // 작은 따옴표를 써서 한 문자를 표현한다
		System.out.println(character);
		char character2 = '\u0041'; // 슬러시u로 시작하면 유니코드를 의미한다.
		System.out.println(character2);
		
		// byte : 정수형 1byte , 대문자 Byte는 클래스
		byte b = 127;
		System.out.println(b);
		System.out.println("Byte 타입의 최댓값 : " + Byte.MAX_VALUE);
		System.out.println("Byte 타입의 최솟값 : " + Byte.MIN_VALUE);
		
		// short : 정수형 2byte
		short sInt = 128;
		System.out.println(sInt);
		System.out.println("Short 타입의 최댓값 : " + Short.MAX_VALUE);
		System.out.println("Short 타입의 최솟값 : " + Short.MIN_VALUE);
		
		// int : 정수형 4byte (정수의 기본 타입)
		int i = 32769;
		System.out.println(i);
		System.out.println("Integer 타입의 최댓값 : " + Integer.MAX_VALUE);
		System.out.println("Integer 타입의 최솟값 : " + Integer.MIN_VALUE);
		
		// long : 정수형 8bute
		long l = 35L; // l 또는 L(리터럴 상수)를 표기하여 long타입임을 명시
		System.out.println(l);
		System.out.println("Long 타입의 최댓값 : " + Long.MAX_VALUE);
		System.out.println("Long 타입의 최솟값 : " + Long.MIN_VALUE);
		
		// float : 실수형 4byte
		float f = 3.14f; // f 또는 F를 붙여 float 타입임을 명시
		System.out.println(f);
		System.out.println("Float 타입의 최댓값 : " + Float.MAX_VALUE);
		System.out.println("Float 타입의 최솟값 : " + Float.MIN_VALUE);
		
		// double : 실수형 8byte (실수의 기본 타입)
		double d = 3.14d; // d 또는 D를 붙여 명시 (생략도 가능)
		System.out.println(d);
		System.out.println("Double 타입의 최댓값 : " + Double.MAX_VALUE);
		System.out.println("Double 타입의 최솟값 : " + Double.MIN_VALUE);
		
		// String : 참조(객체) 타입
		String str = "대한민국";
		
		System.out.println(str.length());
	}
}
