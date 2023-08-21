package com.miniproj.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproj.controller.MemberFactory;
import com.miniproj.service.MemberService;

public class LogoutMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		
		ses.removeAttribute("loginUser");
		ses.invalidate();
		
		MemberFactory mf = MemberFactory.getInstance();
		mf.setRedirect(true);
		mf.setWhereIsGo("../index.jsp");
		
		return mf;
	}

}
