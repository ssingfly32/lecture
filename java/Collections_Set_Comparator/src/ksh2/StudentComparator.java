package ksh2;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getScore() > o2.getScore()) {
			return -1;
		} else if(o1.getScore()==o2.getScore()) {
			return 0;
		} else {
			return 1;
		}
	}
	
}
