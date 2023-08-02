package com.ksh.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 매핑 주소를 String[] 형식으로 여러개를 지정해도 된다.
///JSPBasic/helloServlet로 요청하면 현재 클래스(HelloServlet)가 실행되도록 mapping 함(클래스 이름 감추기 가능)
//@WebServlet({"/hello.do","/hGET"}) 
public class HelloServlet_GET extends HttpServlet {
	/*
	 * GET 방식 요청 : 데이터를 url의 쿼리스트링으로 표현하여 전송하는 방법(x)
	 * - a 태그로 서블릿을 GET방식으로 호출할 수 있다.(페이지 이동)
	 * - 자바스크립트에서 location.href를 통해서 GET방식으로 요청했을 때 (페이지 이동) 
	 * - form 태그의 method=get일 때 (페이지 이동)
	 * - 자바스크립트에서 ajax를 통해 GET 방식으로 요청했을 때 
	 * 
	 */

	@Override
	public void init() throws ServletException { // 최초 실행될 때 객체가 만들어지고 만들어진 객체 계속 사용
		System.out.println("현재 서블릿 객체 " + this.getClass().getName() + "가 생성됨!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 방식으로 요청했을 때 실행되는 메서드
		System.out.println("GET 방식으로 요청 됨");
		String name = req.getParameter("name");
		System.out.println(name + "라고 보냈음");
		
		// GET 방식으로 요청하면 h1 태그로 "hi~"라고 출력(html로 응답)해보자
		// 응답을 html 파일 인코딩 방식을 utf-8로 지정
		resp.setContentType("text/html; charset=utf-8");
		// resp.getWriter() : 클라이언트에 문자 텍스트를 전송할 수 있는 PrintWriter 객체를 리턴합니다.
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>HelloServlet으로 요청되어 응답됨</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1> hi~" + name +  "</h1>");
		out.print("</body>");
		out.print("</html>");
		
		out.flush();
		out.close();
		
	}


	
}
