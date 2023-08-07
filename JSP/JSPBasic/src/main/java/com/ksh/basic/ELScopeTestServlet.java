package com.ksh.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksh.vo.Member;

/**
 * Servlet implementation class ELScopeTestServlet
 */
@WebServlet("/elScope.do")
public class ELScopeTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = 3, num2 = 5;
		int result = num1 + num2;
		
		// request영역에 바인딩
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("result", result);
		
		// session영역에 바인딩
		
		Member m = new Member();
		m.setUserId("dooly");
		m.setMemo("EL이 실행될 때 알아서 getter/setter를 호출하기 때문에 멤버변수를 잘 보고 씁시다.");
		
		request.getSession().setAttribute("member", m);
		
		request.getRequestDispatcher("el_Scope.jsp").forward(request, response);
		
	}

	

}
