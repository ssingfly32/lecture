package ksh;

// 멤버변수, 생성자, getter(), setter(), toString()
public class Student {
	
	// 학생 한명에게 필요한 속성을 멤버변수로 선언
	// 캡슐화를 위해 멤버변수는 private(동일한 클래스에서만 접근 가능)으로 선언
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;
	private String grade;
	
	// 생성자는 객체가 생성될 때 자동으로 실행되며 멤버 변수를 ★초기화★할 목적
	public Student(String stuNo, String stuName, int kor, int eng, int math) { // 매개변수로 무엇을 받을지 생각해보자!
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		// 중복 코드를 없애기 위해 총점, 평균, 등급을 구하는 메소드를 만들고 호출하자.
		processScore();		
	}

	private void processScore() { // 접근제어자 private(동일한 클래스내에서만 접근),void(return타입이 없을 때)
		this.tot = this.kor + this.eng + this.math;
		this.avg = this.tot/3f;
		  if(this.avg <= 100 && this.avg >= 90) {
			  this.grade = "A";
         } else if(this.avg >= 80 && this.avg < 90) {
             grade = "B";
         } else if(this.avg >= 70 && this.avg < 80) {
             grade = "C";
         } else if(this.avg >= 60 && this.avg < 70) {
             grade = "D";
         } else {
             grade = "F";
         }
		
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
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
	
	
}
