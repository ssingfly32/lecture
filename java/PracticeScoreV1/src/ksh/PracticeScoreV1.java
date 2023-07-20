package ksh;

// 여기가 Department (반class)
public class PracticeScoreV1 {
//	반이 가지고 있는 속성
	private static final int STUDENT_CNT = 3;
//	멤버 변수이기 때문에 private(동일한 클래스 내에서만 접근) static(프로그램시작-생성,종료-소멸/모든 객체 공용 사용_
	private Student[] studentList;
//	Student 타입의 배열 선언. Student 타입이기 때문에 student만 들어갈 수 있음.
	private int totlaTot; // 반 총점
	private float totalAvg; // 반 평균
	
	public PracticeScoreV1() { // 생성자
		this.studentList = new Student[STUDENT_CNT];
	}
	
	public void displayMenu() {
		System.out.println(
				"**********************************************************");
		System.out.println(
				"**             성            적            표             **");
		System.out.println(
				"**                                                      **");
		System.out.println(
				"**      1. 학생 입력                                       **");
		System.out.println(
				"**      2. 학생 전체 출력                                   **");
		System.out.println(
				"**      3. 학생 성적 검색(이름검색)                            **");
		System.out.println(
				"**      4. 학생 성적 검색(학번검색)  과제                       **");
		System.out.println(
				"**      5. 학생 성적 수정(국어점수)                            **");
		System.out.println(
				"**      6. 학생 성적 수정(영어점수)  과제                       **");
		System.out.println(
				"**      7. 학생 성적 수정(수학점수)  과제                       **");
		System.out.println(
				"**      8. 학생 성적 내림차순 정렬   과제                       **");
		System.out.println(
				"**      9. 종료                                          **");
		System.out.print("메뉴 입력 >> ");
	}

	public static void main(String[] args) {
		PracticeScoreV1 p = new PracticeScoreV1();
		p.displayMenu();
		
	}

}
