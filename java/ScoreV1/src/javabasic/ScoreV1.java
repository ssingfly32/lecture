package javabasic;

import java.util.Scanner;

public class ScoreV1 {

//	1명의 학생의 이름, 국어, 영어, 수학 점수를 입력받아 성적표 처리 후 출력
	public static void main(String[] args) {
		String stuName = "";
		int kor = 0, eng = 0, math = 0, tot = 0;
		float avg = 0.0f;
		char grade = ' ';
		
		// 유저에게 값을 입력 받기 위해
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 >>>");
		stuName = sc.next();
		
		System.out.println(stuName);
		
		System.out.print("국어 >>>");
		kor = sc.nextInt();
		
		System.out.print("영어 >>>");
		eng = sc.nextInt();
		System.out.print("수학 >>>");
		math = sc.nextInt();
		
//		System.out.println(stuName +","+kor+","+eng+","+math);
		
		tot = kor + eng + math;
        avg = Math.round( tot / 3f * 100)/100f;
        // if(avg <= 100 && avg >= 90) { 그레이드 작은 따옴표로 바꿔라
        //     grade = "A";
        // } else if(avg >= 80 && avg < 90) {
        //     grade = "B";
        // } else if(avg >= 70 && avg < 80) {
        //     grade = "C";
        // } else if(avg >= 60 && avg < 70) {
        //     grade = "D";
        // } else {
        //     grade = "F";
        // }
        
        switch((int)(avg / 10)) {
        case 10:
        case 9:
            grade = 'A';
            break;
        case 8:
            grade = 'B';
             break;
        case 7:
            grade = 'C';
            break;
        case 6:
            grade = 'D';
            break;
        default:
            grade = 'F';
     }
        
        System.out.println("\t\t\t 성 적 표");
        System.out.println("==========================================");
        System.out.println("이름\t 국어 \t 영어\t 수학\t 총점\t 평균\t 학점");
        System.out.println("==========================================");
        System.out.println(stuName + "\t" + kor + "\t" + eng + "\t" + math + "\t " + tot + "\t" +avg+ "\t" + grade + "\t");
        
		
	}

}
