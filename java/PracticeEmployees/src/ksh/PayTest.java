package ksh;

public class PayTest {

	public static void main(String[] args) {
//		Permanent per = new Permanent("1111", "둘리", "청소", 300);
//		Employees 정규직1 = per;
//
//		PartTimer part = new PartTimer("2222", "희동이", "주방", 8, 1);
//		Employees 알바1 = part;
		
//		중복 코드 없애기
		Employees 알바1 = new PartTimer("2222", "희동이", "주방", 8, 1);;
		Employees 정규직1 = new Permanent("1111", "둘리", "청소", 300);
		
		System.out.println(알바1.toString());
		System.out.println(정규직1.toString());
		
	}

}
