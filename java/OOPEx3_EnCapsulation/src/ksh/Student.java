package ksh;

// 이 클래스에 캡슐화가 되도록 getter / setter를 만드시고, toString() 메서드를 작성하세요.
public class Student {

//	멤버 변수
//	[접근제어자] [static] 변수명;
	private String stuNo; 
	private String stuName;
	private int age;
	
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
	
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
//	age값이 0 ~ 150 사이의 값으로만 수정 되도록 한다.
	public void setAge(int age) {
		if(age >0 && age <= 150) {
			
			this.age = age;
		}
	}
	
//	getter
	public String getStuNo() {
		return this.stuNo;
	}
	public String getStuName() {
		return this.stuName;
	}
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return "[" + this.getClass().getName()+"]" + ", stuNo : " + this.stuNo + ", stuName : " + this.stuName + ", age : " + this.age; 
	}
}
