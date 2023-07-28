package ksh;

public class Student{

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
			if(((Student)obj).stuNo.equals(this.stuNo)) {
				result = true;
			}
			
		}
		return result;
	}

	@Override
	public int hashCode() {
		// Object.hashCode() : 
		// 객체가 생성될 때 같은 (객체를 판별하는 unique한 번호) 번호가 부여되지 않도록
		// 내부적으로 해싱 기법에 의해 만들어진 번호를 반환하는 메서드
		return this.stuNo.hashCode();
		
	}


	@Override
	public String toString() {
		return "Student [stuNo=" + this.stuNo + ", stuName=" + this.stuName + ", score="
				+ this.score + " hashCode =" + this.hashCode() + "]";
	}




	
}
