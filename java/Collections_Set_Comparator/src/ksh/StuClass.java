package ksh;

import java.util.Set;
import java.util.TreeSet;

public class StudentTest {

	public static void main(String[] args) {
		Set<Student> studentSet = new TreeSet<>();
		
//		Student s1 = new Student("1111", "둘리", 80);
//		Student s2 = new Student("2222", "희동이", 60);
//		Student s3 = new Student("1111", "둘리", 80);
//		
		studentSet.add(new Student("1111", "둘리", 80));
		studentSet.add(new Student("2222", "희동이", 60));
		studentSet.add(new Student("1111", "둘리", 80));

		for(Student s : studentSet) {
			System.out.println(s.toString());
		}

		
	}

}
