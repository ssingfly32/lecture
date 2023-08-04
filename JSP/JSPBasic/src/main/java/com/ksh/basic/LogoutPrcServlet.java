package com.ksh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class LogoutPrcServlet
 */
@WebServlet("/logout.do")
public class LogoutPrcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 세션 무효화
		HttpSession session = request.getSession();
		
		session.removeAttribute("loginMember"); // 세션에 있는 로그인 정보 지움
		session.invalidate(); // 세션 갱신
		
		// myHome.jsp로 이동
		response.sendRedirect("./myHome.jsp");
	}

	

}
