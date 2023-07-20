package ksh;

import java.util.Scanner;

public class Department { // 멤버 변수(필드)
	private static final int STUDENT_CNT = 3;
	private Student[] studentList;
	private int totalTot;
	private float totalAvg;

	public Department() { // 생성자 : 객체 생성 시 초기화, 리턴 타입 사용x
		this.studentList = new Student[STUDENT_CNT];
	}

	private void outputEntireScore(Department scores) { // 메소드 : 객체 내부의 함수 
														// 객체와 객체간의 상호 작용
		for (Student stu : scores.studentList) {
			System.out.println(stu.toString());
		}
		System.out.println(
				"전체 총점 : " + scores.totalTot + ", 전체 평균 : " + scores.totalAvg);
	}

	private Student inputStudent() {
		Scanner strSc = new Scanner(System.in);
		Scanner numSc = new Scanner(System.in);
		System.out.print("학번 >>> ");
		String stuNo = strSc.next();
		System.out.print("이름 >>> ");
		String stuName = strSc.next();
		System.out.print("국어 >>> ");
		int kor = numSc.nextInt();
		System.out.print("영어 >>> ");
		int eng = numSc.nextInt();
		System.out.print("수학 >>> ");
		int math = numSc.nextInt();

		Student stu1 = new Student(stuNo, stuName, kor, eng, math);
		return stu1;
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

//	이름 검색
	public void searchStudentByName(Student[] studentList) {
		Scanner strSc = new Scanner(System.in);
		System.out.print("이름 >>> ");
		String stuName = strSc.next();
		boolean isEmpty = true;
		
//		향상된 for : 배열에 저장된 전체 데이터를 처리할 경우(0번째부터 끝까지)
//		배열에 저장된 데이터의 0번째 index 위치의 데이터를 변수에 저장하고 반복을
//		시작하며 마지막 index 위치의 데이터를 처리하고 반복을 종료한다.
		for (Student s : studentList) { // studentList[0], studentList[1], studentList[2]
			if (s.getStuName().equals(stuName)) { // String은 equal()메소드로 비교해야한다.
				System.out.println(s.toString());
				isEmpty = !isEmpty;
			}
		}
		if (isEmpty) {
			System.out.println("그런 학생 없습니다.");
		}
	}

//	학번 검색
	public void searchStudentByNo(Student[] studentList) {
		Scanner strSc = new Scanner(System.in);
		System.out.print("학번 >>> ");
		String stuNo = strSc.next();
		boolean isEmpty = true;
		for (Student s : studentList) {
			if (s.getStuNo().equals(stuNo)) {
				System.out.println(s.toString());
				isEmpty = !isEmpty;
			}
		}
		if (isEmpty) {
			System.out.println("그런 학생 없습니다.");
		}
	}

//	국어 수정
	public void updateKorByStuNo(Department scores) {
		Scanner strSc = new Scanner(System.in);
		System.out.print("학번 >>> ");
		String stuNo = strSc.next();

		boolean isFound = false;
		for (Student s : scores.studentList) {
			if (s.getStuNo().equals(stuNo)) {
				Scanner numSc = new Scanner(System.in);
				System.out.print("국어 >>> ");
				int kor = numSc.nextInt();
				if (kor < 0 && kor > 100) {

				} else {
					s.setKor(kor);
					processTotalScore(scores);
					isFound = !isFound;
				}
			}
		}
		if (!isFound) {
			System.out.println("그런 학생 없습니다.");
		}
	}

	public static void main(String[] args) {
		Department scores = new Department(); 
		while (true) {
			scores.displayMenu();
			Scanner menuSc = new Scanner(System.in);
			switch (menuSc.nextInt()) {
			case 1:
				for (int i = 0; i < Department.STUDENT_CNT; i++) {
					scores.studentList[i] = scores.inputStudent();
				}
				scores.processTotalScore(scores);
				break;
			case 2:
				scores.outputEntireScore(scores);
				break;
			case 3:
				scores.searchStudentByName(scores.studentList);
				break;
			case 4:
				scores.searchStudentByNo(scores.studentList);
				break;
			case 5:
				scores.updateKorByStuNo(scores);
				break;
			case 6:
				break;
			case 7:
				break;
			case 9:
				menuSc.close();
				System.out.println("bye bye");
				System.exit(0);
			}
		}
	}

	private void processTotalScore(Department scores) {
		scores.totalTot = 0;
		scores.totalAvg = 0;
		for (int i = 0; i < Department.STUDENT_CNT; i++) {
			scores.totalTot += scores.studentList[i].getTot();
		}
		scores.totalAvg = scores.totalTot / (float) STUDENT_CNT / 3;
	}
}
