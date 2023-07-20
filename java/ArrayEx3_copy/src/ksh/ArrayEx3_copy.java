package ksh;

import java.util.Arrays;

public class ArrayEx3_copy {

	public static void main(String[] args) {
		char[] chArr = new char[] {
			'a', 'b', 'c'	
		};
		System.out.println("변경 전 원본 배열(" + chArr.hashCode() +" )  : " + Arrays.toString(chArr));
		
//		원본 배열을 복사 : 1) 깊은 복사
		char[] copyChArr = new char[chArr.length];
		for(int i = 0; i < chArr.length; i++) {
			copyChArr[i] = chArr[i];
		}
		System.out.println("변경 전 사본 배열(" + copyChArr.hashCode() +" ) : " + Arrays.toString(copyChArr));
		
		chArr[1] = 'B'; // 원본 배열의 값을 수정
		System.out.println("변경 후 원본 배열(" + chArr.hashCode() +" )  : " + Arrays.toString(chArr));
		System.out.println("변경 후 사본 배열(" + copyChArr.hashCode() +" ) : " + Arrays.toString(copyChArr));
		
		if (chArr == copyChArr) { // chArr 객체와 copyChArr 객체의 주소값이 같냐고 물어보는 것
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		System.out.println("================================================================");
		
		// ==================================얕은 복사=============================================
		String[] heros = new String[] {
				"아이언맨","헐크","캡틴아메리카노"
		};
		System.out.println("변경 전 원본 배열(" + heros.hashCode() +" )  : " + Arrays.toString(heros));		
		
		String[] copyHeros = heros; // 얕은 복사
		System.out.println("변경 전 사본 배열(" + copyHeros.hashCode() +" )  : " + Arrays.toString(copyHeros));	
		
		heros[2] = "캡틴아메리카";
		System.out.println("변경 후 원본 배열(" + heros.hashCode() +" )  : " + Arrays.toString(heros));		
		System.out.println("변경 후 사본 배열(" + copyHeros.hashCode() +" )  : " + Arrays.toString(copyHeros));	
		
		if (heros == copyHeros) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
	
	}
}
