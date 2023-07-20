package ksh;

import ksh2.*;

public class OOPEx3_EnCapsulation {

	public static void main(String[] args) {
		Student stu1 = new Student("20230719_1","홍길동",20);
		System.out.println(stu1.introduceStudent());
		
//		만들어진 객체의 속성값을 수정 하고 싶다. (stu1 학생의 나이 값을 수정하고 싶다면..>)
//		new Student("20230719_1","홍길동",21); 안됨. 새로운 객체 생성됨
		
//		Student 객체의 age멤버변수의 접근제어자가 default라서 접근 가능하지만...
//		stu1.age = 21; // 좋은 코드는 아니다.
		stu1.setAge(21);
//	이미 만들어진 dept 객체의 학과명을 "컴퓨터공학과"라고 수정하고싶다. (캡슐화 이용)
		Department dept = new Department(1, "컴공과");
		
		dept.setDeptName("컴퓨터공학과");
		dept.setDeptNo(100);
		
		
//		dept객체의 속성을 얻어 화면에 출력하고 싶다. (getter)
		
		System.out.println(dept.getDeptNo());
		System.out.println(dept.getDeptName());
		
		System.out.println(dept.toString());

	}
	
	
	

}
