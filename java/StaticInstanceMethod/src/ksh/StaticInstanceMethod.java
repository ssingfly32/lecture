package ksh;

import java.util.Date;
import java.util.Scanner;

public class StaticInstanceMethod {

	public static void main(String[] args) {
		// static 키워드가 있는 메서드와 없는 메서드를 구분하여 보자
		
		// [1] static 키워드가 있는 멤버 : 그 메서드(멤버)를 가지고 있는 클래스명.메서드명();
		// 프로그램의 시작과 동시에 메모리에 로딩 - 언제든 호출 가능.
		// 프로그램 종료시에 메모리에 소멸
		// static 멤버 : 해당 클래스의 모든 객체가 공유하는 데이터 
		System.out.println(Math.min(3d, 45d)); // 녹색 동그라미에 s -> .찍고 호출만 하면됨 
		
		// [2] non-static(instance) : static 키워드가 없는 메서드(멤버)
		// 그 메서드(멤버)를 가지고 있는 클래스로부터 객체를 만들고, 객체명.멤버메서드명();
		// instance 멤버는 객체를 생성할 때 메모리에 로딩되고, 객체가 소멸되면 메모리에서 사라진다.
		// instance 멤버는 해당 클래스의 각 객체마다 다른 값을 가질 수 있다.
		
		Scanner sc = new Scanner(System.in); // 객체 생성(앞으로 객체를 만드는 여러가지 방법을 배운다)
		sc.next(); // Scanner 클래스가 가지고 있는 메서드인 next() 호출
		
		
		
		
		
		Date d = new Date();
		d.toLocaleString();
		
		System.out.println();
	
	}

}
