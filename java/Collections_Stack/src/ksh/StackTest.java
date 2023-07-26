package ksh;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {
	
	// Stack : 자료구조의 Stack 구조를 클래스화 한 것.
	// LIFO(Last In First Out) : 먼저 들어간 것이 제일 나중에 나온다.
	// 웹브라우저. 뒤로가기기능, 연산자의 우선순위, 메서드 호출 순서  
	// push() : 스택에 데이터를 저장하는 명령
	// pop() : 스택에서 데이터를 꺼내는 명령(remove)
	// peek() : 스택에서 데이터를 꺼냈다가 다시 집어 넣음.
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.push("네이버1");
		stack.push("네이버 웹툰");
		stack.push("노션");
		stack.push("네이버2");
		
//		while(!stack.empty()) {
//			System.out.println(stack.peek()); 피크로는 반복문 돌리기 힘듦
//		}
		
//		for (int i=stack.size()-1; i>=0; i--) {
//			System.out.println(stack.get(i));
//		}
//			
		
		System.out.println("스택에 남은 데이터 갯수 : " + stack.size());
		
		Iterator<String> iter = stack.iterator();
		System.out.println("<ul>");
		while(iter.hasNext()) {
			System.out.println("<li>" + iter.next() + "</li>");
		}
		System.out.println("</ul>");
	}
}
