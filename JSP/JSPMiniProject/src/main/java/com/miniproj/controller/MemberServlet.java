package com.miniproj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.service.MemberService;



@WebServlet("*.mem") // .mem으로 끝나는 모든 매핑에 대해... 현재 서블릿에서 처리함
public class MemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request,response);
	}
	
	private void doService(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		System.out.println("요청한 페이지 : " + request.getRequestURL());
		System.out.println("요청한 URI : " + request.getRequestURI());
		System.out.println("컨텍스트 패스 : " + request.getContextPath());
		
		// 요청된 서블릿 매핑 주소를 통해 기능을 분류
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("최종 요청된 서비스 : " + command);
		
		// 팩토리패턴 (다형성)
		MemberFactory mf = MemberFactory.getInstance();
		
		MemberService service = mf.getService(command);
		
		service.executeService(request, response);
	}

}
