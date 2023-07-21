package ksh;

public class CalcEx {

	public static void main(String[] args) {
		// +. -. *, / 기능이 있는 계산기 만들기
		// 두 개의 정수를 입력받아 만들도록
		CalcImpl calculator = new CalcImpl();
		System.out.println(calculator.add(3, 5));
	}

}
