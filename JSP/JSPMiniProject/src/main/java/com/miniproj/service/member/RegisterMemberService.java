package com.miniproj.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.MemberFactory;
import com.miniproj.service.MemberService;

public class RegisterMemberService implements MemberService {

	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 5;	// 하나의 파일블럭의 버퍼 사이즈 5MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;	// 최대 파일 사이즈 10MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 15;	// 최대 request 사이즈 15MB
	
	
	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입하자");
		
		// 파일과 함께 데이터를 받았다면 request.getParameter()로 데이터를 수집하면 안된다.(!)
		
		
		
		return null;
	}

}
