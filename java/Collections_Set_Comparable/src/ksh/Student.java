package ksh;


public class Student implements Comparable<Student>{

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

	@Override
	public int compareTo(Student o2) {
		int result = 0;
		if(this.getScore() < o2.getScore()) {
			result = 1;
		} else if(this.getScore() > o2.getScore()){
			result = -1;
		} else { // 점수가 같다면 학번 오름차순
			// 문자열은 > , <, >=, <= 연산자를 사용하지 못한다.
			// 그러나 String 클래스가 Comparable 인터페이스를 상속받아 compareTo 메서드를
			// 구현했기 때문에 String.compareTo()를 이용하여 비교(유니코드 값)한다.
			int tmp = this.getStuNo().compareTo(o2.getStuNo());
			if(tmp > 0){
				result = 1;
			} else  {
				result = -1;
			} 
		}
		return result;
	}




	
}
