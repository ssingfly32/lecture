package com.ksh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProcessEx
 */
@WebServlet("/loginProcEx1.do")
public class LoginProcessEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 아직 JDBC를 다 배우지 않았으므로 DB에 회원 테이블에 
		// 아이디 : abcd123, 비밀번호 : abcd123! 라는 회원이 있다고 가정하고 프로그래밍을 하자/
		// 로그인 성공하면 home.jsp로 이동시키고, 로그인 실패하면 loginEx1.jsp로 이동시키자.
		
		// request 객체로 넘어온 데이터를 인코딩 처리
		req.setCharacterEncoding("utf-8");
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		// 서블릿에서 페이지를 이동시키는 방법 4가지
		
		// 1. response 객체의 sendRedirect() 를 이용하여 이동시키는 법
//		if(userId.equals("abcd123") && userPwd.equals("abcd123!")) {
//			// 로그인 성공
//			resp.sendRedirect("./home.jsp");
//		} else {
//			resp.sendRedirect("./loginEx1.jsp?status=fail");
//		}
		
	
		// 2. javascript를 이용하여 이동
//		resp.setContentType("text/html; charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.print("<script>");
//		if(userId.equals("abcd123") && userPwd.equals("abcd123!")) {
//			// 로그인 성공
//			out.print("location.href='./home.jsp';");
//		} else {
//			out.print("location.href='./loginEx1.jsp?status=fail';");
//		}
//		out.print("</script>");
//		out.flush();
//		out.close();
	
		
		HttpSession ses = req.getSession(); // 요청된 request로부터 Session객체를 얻어옴
		
		// 3. RequsetDispatcher 객체를 이용하여 이동시키는 방법
		// 특징 : url 주소가 바뀌지 않는다
		// 특징 : 보통 데이터를 바인딩하여 보낼 때 사용한다.
//		if(userId.equals("abcd123") && userPwd.equals("abcd123!")) {
//			// 로그인 성공
//			req.setAttribute("loginUser", userId); // 데이터 바인딩
//			ses.setAttribute("msg", "메롱"); // 세션 객체에 msg라는 이름으로 "메롱" 저장
//			req.getRequestDispatcher("./home.jsp").forward(req, resp);
//			
//		} else {
//			req.getRequestDispatcher("./loginEx1.jsp?status=fail").forward(req, resp);
//		}
		
		
		
		// 4. meta 태그의 <meta http-equiv='refresh" content='5; url=이동할페이지'> 태그 이용 (거의안씀)
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<head>");
		if(userId.equals("abcd123") && userPwd.equals("abcd123!")) {
			// 로그인 성공
			out.print(" <meta http-equiv='refresh' content='5; url=home.jsp'>");
		} 
		out.print("</head>");
		out.flush();
		out.close();
		
	}
	
}
