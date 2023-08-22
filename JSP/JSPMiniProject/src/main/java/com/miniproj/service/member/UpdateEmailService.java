package com.miniproj.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;

public class updateEmailService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberFactory mf = MemberFactory.getInstance();


		String email = request.getParameter("iuserEmail");
		System.out.println(email);
		MemberDAO mdao = MemberCRUD.getInstance();
//		mdao.updateEmail();
		return null;
	}

}
