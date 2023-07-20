package ksh;


public class Student {

//	멤버 변수
	String stuNo; 
	String stuName;
	int age;
	
//	기본 생성자 : 매개변수가 없는 생성자. 생략 가능
	public Student() {
		System.out.println("기본생성자 호출됨. 학생 한 명 입학!!!");
	}
	
//	public Student(String stuNo) {
////		자기 자신 객체의 생성자를 재 호출하는 코드는 반드시 생성자의 첫 라인에 기술해야 한다.
//		this(); // 기본 생성자 재호출(객체는 새로이 생성되지 않는다)
//		// 지역변수 stuNo라는 값을 받아와서 멤버변수 stuNo에 할당.
//		this.stuNo = stuNo;
//	}
//	
	
//	생성자는 보통 멤버 변수의 값을 초기화 하는 역할을 하므로, 객체가 가지고 있는
//	모든 속성의 값을 초기화 할 수 있는 생성자를 두는 것이 좋다.
//	보통 모든 멤버 변수를 초기화 하는 생성자를 두고 
//	나머지 생성자들은 필요 할 때 모든 변수를 초기화 하는 생성자를 재호출 하는 방식으로 코딩한다.
	public Student(String stuNo, String stuName, int age) {
		this();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.age = age;
	}
	
//	보통 모든 멤버 변수를 초기화 하는 생성자를 두고 
//	나머지 생성자들은 필요 할 때 모든 변수를 초기화 하는 생성자를 재호출 하는 방식으로 코딩한다.
	public Student(String stuName) {
		this(null, stuName, 0);
	}
	
	public Student(String stuName, int age) {
		this(null, stuName, age);
	}
	
	
//	멤버 메서드
	public String introduceStudent() {
		return "학번은" +this.stuNo +"이고, 이름은 "  + this.stuName + "이며, 나이는" + this.age + "살 입니다.";
		
	}
}
