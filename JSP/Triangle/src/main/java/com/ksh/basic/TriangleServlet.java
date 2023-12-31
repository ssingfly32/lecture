package com.ksh.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksh.vo.TriangleVo;

@WebServlet("/Triangle.do")
public class TriangleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 방식으로 요청됨");
		int base = Integer.parseInt(req.getParameter("base"));
		int height = Integer.parseInt(req.getParameter("height"));
		
		if (base != 0 && height != 0) {
			
			TriangleVo tri = new TriangleVo(base, height);
			
			req.setAttribute("triangle", tri);
			req.getRequestDispatcher("./callTData.jsp").forward(req, resp);
		}
		
		
	}
	
}
