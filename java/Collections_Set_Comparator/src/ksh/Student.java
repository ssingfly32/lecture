package ksh;

import java.util.Comparator;

public class Student implements Comparable<Student> {

	private String stuNo;
	private String stuName;
	private int score;
	
	public Student(String stuNo, String stuName, int score) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.score = score;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Student) {
			Student tmp = (Student) obj;
			if ((this.stuNo.equals(tmp.stuNo))
					&& (this.stuName.equals(tmp.stuName))) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		return (this.stuNo+this.stuName).hashCode();
		
	}


	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", score="
				+ score + "]";
	}

	@Override
	public int compareTo(Student o) {
		if(score>o.score) {
			return -1; // 앞에 오게 하려면 음수를 리턴
		} else if(score==o.score) {
			return 0;
		} else return 1; // 뒤에 오게 하려면 양수를 리턴
	}


	
}
