package com.miniproj.service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;

public class UpdateEmailService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses = request.getSession();
		Member mem = (Member)ses.getAttribute("loginUser");
		String userId = mem.getUserId();
		System.out.println("userId : " + userId);
		
		String userEmail = request.getParameter("iuserEmail");
		System.out.println(userEmail + "," + userId);
		MemberDAO mdao = MemberCRUD.getInstance();
		try {
			

			if(mdao.updateEmail(userId, userEmail) == 1) {
				System.out.println("이메일 수정 완료");
				response.sendRedirect("myPage.mem?userId=" + userId);
			};
			
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
