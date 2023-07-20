package ksh;

import java.util.Arrays;

public class ArrayEx4_mainArgs {

	public static void main(String[] args) {
		System.out.println("args의 내용 : " + Arrays.toString(args));
		
		if(args.length > 0) { // 매개 변수가 있다면...
			for(int i = 0; i<args.length; i++) {
//					 \한개는 escape sequence(취소 문자)로 인식되어 역슬러시 출력하려면 \\ 두개써야함
				if(args[i].equals("\\w")) {// 문자열의 값을 비교할 땐 .equals()함수 이용 중요!!
					System.out.println("와이드하게 출력");
				}
			}
		}
	}

}
