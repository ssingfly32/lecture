package ksh;

import java.util.*;

public class OOPEx2_Constructor1 {

	public static void main(String[] args) {
//		객체 생성(기본 생성자 호출)
		Student stu1 = new Student();
		System.out.println(stu1.introduceStudent());

		
		Student stu2 = new Student("20230719_1");
		System.out.println(stu2.introduceStudent());
		
		Student stu3 = new Student("20230719_2", "홍길동", 20);
		System.out.println(stu3.introduceStudent());

	}

}
