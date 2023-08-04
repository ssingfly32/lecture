package com.ksh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcEx2
 */
@WebServlet("/loginProcEx2.do")
public class LoginProcEx2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 : abcd123, 비밀번호 : abcd123!이라면 로그인 성공 (myHome.jsp 이동)
		
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// session 객체를 request객체로부터 얻어옴
		// 로그인을 요청한 객체가 저장되어 있는 세션 영역을 얻어온다는 의미.
		// ex) A라는 컴퓨터가 로그인을 했다면 A가 가지고 있는 세션 객체에
		// 로그인 정보를 저장해야 하니까..
		HttpSession ses = request.getSession();
		
		if(userId.equals("abcd123") && userPwd.equals("abcd123!")) {
			// 로그인 처리
			ses.setAttribute("loginMember", userId); // 세션 객체에 로그인 성공한 유저의 아이디 저장
			response.sendRedirect("myHome.jsp");
		} else {
			response.sendRedirect("./loginEx2.jsp?status=fail");
		}
	}

}
