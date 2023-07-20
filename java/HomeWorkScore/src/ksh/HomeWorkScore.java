package ksh;

public class HomeWorkScore {

	public static void main(String[] args) {
		Student stu1 = new Student("001", "홍길동", 90, 80, 70);
		Student stu2 = new Student("002", "김철수", 85, 95, 90);
		Student stu3 = new Student("003", "이영희", 70, 75, 80);
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
		System.out.println(stu3.toString());
	}

}
