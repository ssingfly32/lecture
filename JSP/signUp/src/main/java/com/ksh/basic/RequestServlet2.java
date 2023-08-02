package com.ksh.basic;


import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ksh.vo.Member2;

@WebServlet("/useRequest2")
public class RequestServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post로만 호출하세요");
		resp.sendRedirect("./useRequest2.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userName = req.getParameter("userName");

	
		Member2 member = new Member2(userId, userPw, userName);
		
		// member 객체를 Request에 바인딩
		req.setAttribute("userInfo", member);
		
		// View단으로 넘겨주자
		req.getRequestDispatcher("./useRequest2.jsp").forward(req, resp);
		
		
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		System.out.println("userName : " + userName);
	
		
	}
	
}
