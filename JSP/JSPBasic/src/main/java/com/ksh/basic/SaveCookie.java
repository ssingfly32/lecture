package com.ksh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveCookie
 */
@WebServlet("/saveCook.do")
public class SaveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키 객체 생성
		Cookie myCookie = new Cookie("mySesId", request.getSession().getId());
		// 만료일 설정
		myCookie.setMaxAge(60*60*24); // 1일동안 쿠키 저장
		
		response.addCookie(myCookie); // 쿠키 저장
	}

	

}
