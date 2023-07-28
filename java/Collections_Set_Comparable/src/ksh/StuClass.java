package ksh;

import java.util.Set;
import java.util.TreeSet;

public class StuClass {

	public static void main(String[] args) {
		Student s1 = new Student("1111", "둘리", 80);
		Student s2 = new Student("2222", "희동이", 60);
		Student s3 = new Student("3333", "둘", 80);

		Set<Student> sortedStuList = new TreeSet<Student>();
		// add 할 때 에러 안남. 컴퍼레이터는 심판 객체를 만듦. 반대로 comparable구현하면 객체 스스로가 비교할 수 있는
		// 능력가짐.
		sortedStuList.add(s1);
		sortedStuList.add(s2);
		sortedStuList.add(s3);

		for (Student s : sortedStuList) {
			System.out.println(s.toString());
		}

	}

}
