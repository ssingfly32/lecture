package ksh;

// (과제) 지금까지 배웠던 모든 프로그래밍 문법을 동원하여 아래의 조건에 맞는 프로그램을 만드세요.

// 1명의 학생이 학번, 이름, 국어, 영어, 수학, 총점, 평균, 등급을 가지고 있습니다.

// 3명의 학생의 성적을 처리 하는 프로그램을 작성하세요.
public class Student {

//	멤버 변수
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;
	private String grade;

	// 생성자는 객체가 생성될 때 자동으로 실행되며 멤버 변수를 초기화 시킬 목적
	public Student(String stuNo, String stuName, int kor, int eng, int math) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		processScore();

	}

//	학생의 총점, 평균, 학점을 처리하는 메서드
	private void processScore() {
		this.tot = this.kor + this.eng + this.math;
		this.avg = this.tot / 3f;
		if (this.avg <= 100 && this.avg >= 90) {
			this.grade = "A";
		} else if (this.avg >= 80 && this.avg < 90) {
			this.grade = "B";
		} else if (this.avg >= 70 && this.avg < 80) {
			this.grade = "C";
		} else if (this.avg >= 60 && this.avg < 70) {
			this.grade = "D";
		} else {
			this.grade = "F";
		}
	};

	@Override // 오버라이딩이란? 상위 클래스가 가지고 있는 메소드를 하위 클래스가 재정의 해서 사용한다.
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", kor="
				+ kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + ", grade=" + grade + "]";
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		processScore();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

//	필요없는 세터 주석 처리
//	public void setTot(int tot) {
//		this.tot = tot;
//	}

	public float getAvg() {
		return avg;
	}

//	public void setAvg(float avg) {
//		this.avg = avg;
//	}

	public String getGrade() {
		return grade;
	}

//	public void setGrade(String grade) {
//		this.grade = grade;
//	}

	public String getStuNo() {
		return stuNo;
	}

}
