package ksh;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_Throws {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 >>>");
		int result = 0;
		try {
		result = inputData(sc);
		} catch (InputMismatchException ime) { 
			System.out.println("정수를 입력하세요");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다");
		}
		System.out.println(result);
	}

	private static int inputData(Scanner sc) 
			throws InputMismatchException, ArithmeticException {
		int result = 0;

		int input = sc.nextInt();
		result = 100 / input;
		return result;
	}
}
