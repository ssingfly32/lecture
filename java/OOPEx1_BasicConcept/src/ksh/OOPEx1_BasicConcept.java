package ksh;

public class OOPEx1_BasicConcept {

	public static void main(String[] args) {
//		객체 생성
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();

//		객체는 서로 주소가 다르다
		System.out.println(stu1.hashCode());
		System.out.println(stu2.hashCode());
		System.out.println(stu3.hashCode());
		
//		객체의 속성에 값을 부여할 수 있다
		stu1.stuNo = "20230718_1";
		stu1.stuName = "홍길동";
		stu1.age = 20;
		
		stu2.stuNo = "20230718_2";
		stu2.stuName = "둘리";
		stu2.age = 18;
		
		stu3.stuNo = "20230718_3";
		stu3.stuName = "도우너";
		stu3.age = 22;
		
		
		
//		객체의 속성 값을 얻어와서 출력
//		System.out.println("stu1의 이름 : " + stu1.stuName);
//		System.out.println("stu1의 이름 : " + stu1.stuNo);
//		System.out.println("stu1의 이름 : " + stu1.age);
//		
//		System.out.println("stu2의 이름 : " + stu1.stuName);
//		System.out.println("stu2의 이름 : " + stu1.stuNo);
//		System.out.println("stu2의 이름 : " + stu1.age);
//		
//		System.out.println("stu3의 이름 : " + stu1.stuName);
//		System.out.println("stu3의 이름 : " + stu1.stuNo);
//		System.out.println("stu3의 이름 : " + stu1.age);

//		멤버 메서드(introduceStudent())를 이용해서 객체의 속성값을 얻어와서 출력
		System.out.println(stu1.introduceStudent());
		System.out.println(stu2.introduceStudent());
		System.out.println(stu3.introduceStudent());


	}

}
