package ksh;

import java.util.ArrayList;

public class WhyUseGeneric {

	public static void main(String[] args) {
		ArrayList<Object> arr = new ArrayList<Object>(); // raw 타입으로 생성한 ArrayList 객체
		// raw 타입으로 객체를 생성하면 Object 타입으로 형변환 되어 데이터가 관리 된다.
		arr.add(1); arr.add(3); arr.add(4); arr.add(5); 
		arr.add(2); // int -> Object 타입으로 변환됨 (Boxing : 값타입 -> 참조타입)
		
		int sum = 0;
		for (Object o : arr) {
			sum += (int)o; // Object -> int 타입으로 형변환(Unboxing : 참조타입 -> 값타입)
		}
		System.out.println(sum);
		
		// ---------------------------------------------------------------------------------
		// Generic 타입을 사용하면
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(new Integer(1)); arr2.add(new Integer(2));
		arr2.add(new Integer(3));arr2.add(new Integer(4));
		arr2.add(new Integer(5));
		
		int sum2 = 0;
		for (Integer i : arr2) {
			sum2 += i; 
		}
		System.out.println(sum2);
	}
}
