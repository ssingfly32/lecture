package ksh;

public class Student {

//	멤버 변수
	String stuNo; 
	String stuName;
	int age;
	
//	멤버 메서드
	public String introduceStudent() {
		return "학번은" +this.stuNo +"이고, 이름은 "  + this.stuName + "이며, 나이는" + this.age + "살 입니다.";
		
	}
}
