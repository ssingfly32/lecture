package ksh;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		StuClass c1 = new StuClass(1);
		
		Student s1 = new Student("1111", "둘리", 80);
		Student s2 = new Student("2222", "고길동", 60);
		Student s3 = new Student("3333", "희동", 80);
		Student s4 = new Student("4444", "마이콜", 90);
		
		c1.addStudent(s1); c1.addStudent(s2);c1.addStudent(s3);c1.addStudent(s4);
		c1.outputEntireStudents();
		
		while(true) {
			System.out.println("정렬기준 입력 (1.학번 2.이름 3.점수) >>> ");
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			Set<Student> sortedStuList = new TreeSet<Student>(SortManager.getSortMethod(menu));
			sortedStuList.addAll(c1.getStuSet());
			
			for(Student s : sortedStuList) {
				System.out.println(s.toString());
			}
			
		}
	}

}
