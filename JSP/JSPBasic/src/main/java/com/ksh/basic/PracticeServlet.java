package com.ksh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pGet")
public class PracticeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식으로 요청됨");
		
		String name = req.getParameter("pname");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>HelloServlet으로 요청되어 응답됨</title>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<h1> hi~" + name +  "</h1>");
		pw.print("</body>");
		pw.print("</html>");
		
		pw.flush();
		pw.close();
	}
	
	
}
