package com.miniproj.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;

public class DuplicateUserIdService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("아이디 중복인지 아닌지 검사하자!");
		
		String tmpUserId = request.getParameter("tmpUserId");
		
		MemberDAO mdao = MemberCRUD.getInstance();
		mdao.duplicateUserId(tmpUserId);
		
		return null;
	}

}
