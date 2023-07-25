package ksh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_BasicConcept {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 >>>");
		
		int result = 0;
		try {
			int input = sc.nextInt();
			result = 100 / input;
		} catch (InputMismatchException ime) { 
			System.out.println("정수를 입력하세요"); // 다중 캐치 블럭
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다");
		} catch (Exception e) { // 위 예외 외 다른 예외가 발생할 수도 있으니
			System.out.println("어떤 예외인지는 모르겠으나 위에서 처리되지 않은 나머지 예외들을 처리");
		} finally {
			System.out.println("바이바이");
		}
		
		System.out.println(result);
	}

}
