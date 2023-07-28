package ksh;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		// 배열을 생성해 보자
		int[] scores = new int[3];
		System.out.println(scores.hashCode());
		
//		배열의 요소에 값 할당
		scores[0] = 45;
		scores[1] = 23;
		// scores [2] = "우리나라"; 선언된 데이터 타입의 값만 들어간다 문자x
		scores[2] = 100; 
//		scores[3] = 120; 에러 (배열의 인덱스 범위에서 벗어남)
		System.out.println(scores[2]);
		
		
//		배열 변수에 새로운 배열이 대입
		scores = new int[5];
		System.out.println(scores.hashCode()); // 배열의 주소가 바뀜
		System.out.println(scores[2]); // 배열의 값도 초기화
		
//		배열의 각 요소에 초기값을 할당하면서 배열을 생성 할 수 있다.
		int[] scores2 = {100, 20, 30, 40, 50}; // 배열을 초깃값을 할당 하면서 생성시엔 배열 크기를 안 줘도 된다.
		System.out.println(Arrays.toString(scores2));
		
		String[] heros = {"아이언맨", "헐크", "스파이더맨", "닥터스트레인지"};
//		배열의 모든 요소 반복
		for(int i = 0; i<heros.length; i++) {
			System.out.println(heros[i]);
		}
//		자바 스크립트의 for ... of 와 같은 용법
		for (String hero : heros) {
			System.out.println(hero+"는 멋있다");
		}

//		2차원 배열
		int[][] arr = new int[3][4];
		
//		자바에서의 배열은 자바스크립트와는 다르게 동적 배열이 아니라 쓰기가 불편하다.
//		그래서 간단한 작업에만 쓰이고 거의 쓰이지 않는다
		
	}

}
