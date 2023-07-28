package ksh;

import java.util.HashSet;
import java.util.Set;

public class StuClass {
	private int classNo;
	private Set<Student> stuSet;
	public StuClass(int classNo) {
		super();
		this.classNo = classNo;
		this.stuSet = new HashSet<Student>();
	}
	public int getClassNo() {
		return classNo;
	}
	
	
	
	public Set<Student> getStuSet() {
		return stuSet;
	}
	public void addStudent(Student s) {
		this.stuSet.add(s);
	}
	
	public void outputEntireStudents() {
		for(Student s : this.stuSet) {
			System.out.println(s.toString());
		}
	}
	@Override
	public String toString() {
		return "StuClass [classNo=" + classNo + ", stuSet=" + stuSet + "]";
	}
	
	
}
