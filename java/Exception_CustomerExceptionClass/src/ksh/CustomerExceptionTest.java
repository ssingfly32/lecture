package ksh;

import java.util.Scanner;

public class CustomerExceptionTest {

	
	public static void main(String[] args) {
		int input = 0;
		while(true) {
			
		Scanner sc = new Scanner(System.in);
		System.out.println("양수를 입력하세요 >>>");
		
		input = sc.nextInt();
		if (input > 0 ) {
			break;
		} else {
			try {
				throw new NotPositiveInteger("양수가 아닙니다"); // 객체 생성해서 던짐
			} catch(NotPositiveInteger npi) {
				System.out.println(npi.getMessage()); 
				npi.printStackTrace();
				System.out.println("에러코드 : " + npi.getErrCode());		
			}
		}
		
		
		}
		
		System.out.println(input);
		
	}

}
