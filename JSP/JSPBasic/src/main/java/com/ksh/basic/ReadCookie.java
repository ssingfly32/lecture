package com.ksh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/readCook.do")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cooks = request.getCookies();
		
		for (Cookie c : cooks) {
			if(c.getName().equals("mySesId")) {
				// 내가 찾는 쿠키
				System.out.println(c.getValue());
			}
		}
		
		// 쿠키를 삭제하고 싶다면
		// 자바스크립트에 만료일을 현재날짜 현재시간으로 재설정
		
		Cookie myCook = new Cookie("mySesId", "");
		myCook.setMaxAge(0); // 쿠키 지우기
		response.addCookie(myCook); // 해당 쿠키를 다시 저장
	}

	
}
