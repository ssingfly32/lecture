package ksh;

import java.awt.Color;

//import java.lang.Math; -> 생략가능 java.lang 기본 패키지는 이미 import 되있다.

import java.awt.Frame;

public class MyWindow extends Frame{
	public MyWindow(String title) {
		super(title); // 부모 생성자 호출
	}
	public static void main(String[] args) {
		// 디버깅 해보면 상속 계층도를 따라 모든 부모 객체들이 생성됨을 알 수 있다.
		MyWindow win = new MyWindow("나의 윈도우");
		System.out.println(win.toString());
		win.setSize(640, 480);
		win.setBackground(new Color(0, 0, 255));
		win.setVisible(true);
		
	}

}
