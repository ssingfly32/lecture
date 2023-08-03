package com.ksh.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksh.vo.Member;

@WebServlet("/useRequest.do")
public class RequestServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("이 서블릿은 포스트로만 하세요");
		
		// HttpServletResponse객체를 통해 이동 
		resp.sendRedirect("./useRequest.jsp"); // 페이지 이동
		
		// 자바스크립트로 페이지 이동
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter write = resp.getWriter();
		write.print("<html>");
	      write.print("<head>");
	      write.print("<script>");
	      write.print("location.href='./useRequest.jsp';");
	      write.print("</script>");
	      write.print("</head>");
	      write.print("</html>");
	      
	      write.flush();
	      write.close();
		
		//write.print .... 어쩌고
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		System.out.println("!");
		
		req.setCharacterEncoding("utf-8");
		// Request 객체로부터 넘겨진 parameter로 받아오기 전에 인코딩 해야 함(POST 방식일 경우)
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userName = req.getParameter("userName");
		
		// 라디오버튼 : 여러개 중에 하나 (단일 선택)
		String gender = req.getParameter("gender");
		String military = req.getParameter("military");
		
		// 체크박스 : 여러개 중에 여러개 (다중선택)
		String[] hobbiesArr = req.getParameterValues("hobby");
		String hobbies = "";
		for(int i =0; i<hobbiesArr.length; i++) {
			if(i != hobbiesArr.length-1) {
				hobbies += hobbiesArr[i] + ",";
			} else {
				hobbies += hobbiesArr[i];
			}
		}
		
		// select ~ option : multiple 속성을 사용하지 않으면 단일 선택
		String job = req.getParameter("job");
		
		if(req.getParameter("birth") == null || req.getParameter("birth").equals("")) {
			PrintWriter write = resp.getWriter();
			write.print("<html>");
			write.print("<head>");
			write.print("<script>");
			write.print("alert('생일은 반드시 입력해 주세요')");
			write.print("location.href='./useRequest.jsp';");
			write.print("</script>");
			write.print("</head>");
			write.print("</html>");
		}
		
		String birthStr = req.getParameter("birth");
		Date birthDate = Date.valueOf(birthStr);
		
		String memo = req.getParameter("memo");
		
//		// getParameterNames(); 몇백개가 되도 간단하게 쓰는법
//		Enumeration<String> enums = req.getParameterNames();
//		while(enums.hasMoreElements()) {
//			String tmp = enums.nextElement();
//			System.out.println(tmp + ":" + req.getParameter(tmp));
//		}
		
		resp.setContentType("text/html; charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		
//		out.print("<html>");
//		out.print("<head>");
//		out.print("</head>");
//		out.print("<body>");
//		out.print("<div> 아이디 : " + userId + "</div>");
//		out.print("<div> userPwd : " + userPwd + "</div>");
//		out.print("<div> userName : " + userName + "</div>");
//		out.print("<div> gender : " + gender + "</div>");
//		out.print("<div> military : " + military + "</div>");
//		out.print("<div> hobbies : " + hobbies + "</div>");
//		out.print("<div> job : " + job + "</div>");
//		out.print("<div> birthStr : " + birthStr + "</div>");
//		out.print("<div> memo : " + memo + "</div>");
//		out.print("</body>");
//		out.print("</html>");
//		
//		out.flush();
//		out.close();
		
		Member member = new Member(userId, userPwd, userName, gender, military, hobbies, job, birthDate, memo);
		
		// member 객체를 Request에 바인딩
		req.setAttribute("userInfo", member);
		
		// View단으로 넘겨주자
		req.getRequestDispatcher("./useRequest.jsp").forward(req, resp);
		
		
		System.out.println("userId : "+userId);
		System.out.println("userPwd : "+userPwd);
		System.out.println("userName : "+userName);
		System.out.println("gender : "+gender);
		System.out.println("military : "+military);
		System.out.println("hobbies : "+hobbies);
		System.out.println("job : "+job);
		System.out.println("birthStr : "+birthStr);
		System.out.println("memo : "+memo);


		
	}

	
}
