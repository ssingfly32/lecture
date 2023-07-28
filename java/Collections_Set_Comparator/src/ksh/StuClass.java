package ksh;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StuClass {
	
	private int classNo;
	private Set<Student> stuSet;
	public StuClass(int classNo) {
		this.classNo = classNo;
		// TreeSet에 정렬기준(DescendingByScoreComparator) 객체를 넘겨주어 생성
		this.stuSet = new TreeSet<Student>(new DescendingByScoreComparator());
	}

	public static void main(String[] args) {
		Set<Student> stuList = new HashSet<>(); // 다형성을 이용해서 앞에는 Set으로 뒤에는 내가 쓸 실제 클래스
		
//		Student s1 = new Student("1111", "둘리", 80);
//		Student s2 = new Student("2222", "희동이", 60);
//		Student s3 = new Student("1111", "둘리", 80);
		
		StuClass class1 = new StuClass(1);
//		
		stuList.add(new Student("1111", "둘리", 80));
		stuList.add(new Student("1111", "둘리", 70));
		stuList.add(new Student("2222", "희동이", 60));
		
		class1.stuSet.addAll(stuList);
		
		for(Student s : class1.stuSet) {
			System.out.println(s.toString());
		}
		

		
	}

}
