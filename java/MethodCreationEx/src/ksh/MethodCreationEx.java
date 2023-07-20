package ksh;

//[접근제어자] [static] 반환값의 데이터 타입 | void 메서드명 ([매개변수1, 매개변수2, ...]) {
//	// 메서드가 수행되면 해야 할 일
//	[return 반환값;]
//// 대괄호는 생략가능....
//}


public class MethodCreationEx {
	
	// 두 개의 정수를 매개변수로 받아 그 합을 반환하는 메서드를 만들어보자
	public static long addTwoInt(int a, int b) {
			return (long)a + (long)b;
		
	}
	// 이름이 outputTimes이고, 매개변수를 String과 int를 받아
	// 그 String을 n번 화면에 출력하는 메서드를 만드세요. static
	public static void outputTimes(String str, int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		long sum =  MethodCreationEx.addTwoInt(2147483647, 1);
		System.out.println(sum);
		
		// static 메서드를 호출한 곳과 메서드를 정의한 곳의 클래스가 같으면 호출할 때 클래스명을 생략 가능
		System.out.println(addTwoInt(3,5));
		
		outputTimes("배고푸다", 4);
		
		float sumf = floatTwoNumbers(3f, 4f, 5f);
		
		int[] arr = {3, 5, 7};
		System.out.println(sumOfArray(arr));
		
		MethodCreationEx mce = new MethodCreationEx(); // 객체 생성
		System.out.print(mce.isEven(6));
		
		String[] heros = {"캡틴아메리카노","헐크","아이언맨"};
//		MethodCreationEx mce2 = new MethodCreationEx(); // 객체 생성
		System.out.print(mce.myIndexOf(heros,"스파이더맨"));
	}
	
	// 정수 하나를 매개변수로 전달 받아 그 수가 짝수이면 true, 홀수이면 false 반환하는 메서드(instance)
	public boolean isEven(int num) {
		return (num % 2 == 0)? true : false;
	}
	
	
	// 문자열 배열을 넘겨받고, 문자열을 넘겨받아 해당 문자열이 배열에 있다면 true, 없다면 false 반환(instance)
	public boolean myIndexOf(String[] arr, String str) {
		boolean result = false;
		for (int i = 0; i<arr.length; i++) {
			if(arr[i].equals(str)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	
	// int 배열을 매개변수로 전달받아 그 배열에 있는 합을 반환하는 메서드(static)
	public static int sumOfArray(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	
	
	public static float floatTwoNumbers(float num1, float num2, float num3) {
		return num1 + num2+ num3;
	}

}
