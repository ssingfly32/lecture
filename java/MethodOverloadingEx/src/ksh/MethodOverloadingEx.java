package ksh;

//  메서드 오버로딩의 조건
//1) 같은 클래스 내에 있어야 한다
//2) 메서드의 이름이 동일해야 한다
//3) 메서드의 시그니쳐(method signature) : 매개변수의 타입이나 갯수, 매개변수의 순서가 달라야 한다.
//4) 반환 값 타입, static | non-static은 같지 않아도 상관없다
public class MethodOverloadingEx {
	
	public static int add2Number(int a, int b) {
		return a + b;
	}
	
	public static float add2Number(float a, float b) {
		return a + b;
	}
	
	public double add2Number(float a, double b) {
		return a + b;
	}
//	위아래는 순서만 바꿨을뿐 순서같으면 x
	public double add2Number(double a, float b) {
		return a + b;
	}


	public double add2Number(short a, float b, int c) {
		return a + b;
	}


	public static void main(String[] args) {
		System.out.println(add2Number(3f, 20f));
		
		System.out.println(add2Number(3, 5));
		
		MethodOverloadingEx moe = new MethodOverloadingEx();
		
		System.out.println(moe.add2Number(3d, 2f));
		
		System.out.println(moe.add2Number((short)2, 2f,5));
	}

}
