package com.ksh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hPost")
public class HelloServlet_Post extends HttpServlet {

	// 현재 클래스가 POST 방식으로 요청될 때 호출되는 메서드
	// POST : 보내진 데이터가 패킷의 header 부분에 저장되어 정보가 전송되는 호출 방식
	/*
	 * POST방식으로 요청하는 방법 1) form 태그에서 method=post 일 때 2) ajax에서 post방식으로 호출했을 때
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post 방식으로 요청 됨");
		
		req.setCharacterEncoding("utf-8"); // request 객체로 보내진 데이터를 utf-8로 인코딩

		String name = req.getParameter("name");
		System.out.println(name + "라고 보냈음");

		// GET 방식으로 요청하면 h1 태그로 "hi~"라고 출력(html로 응답)해보자
		// 응답을 html 파일 인코딩 방식을 utf-8로 지정
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>HelloServlet으로 요청되어 응답됨</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1> hi~" + name + "</h1>");
		out.print("</body>");
		out.print("</html>");

		out.flush();
		out.close();
	}

}
