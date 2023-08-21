package com.miniproj.service.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;

public class LoginMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberFactory mf = MemberFactory.getInstance();
		
		MemberDAO dao = MemberCRUD.getInstance();
		
		try {
			Member loginMember = dao.loginMember(userId, userPwd);
			
			if (loginMember != null) { // 로그인 성공
				// member 테이블 update + 포인트 로그 남기기
				dao.addPointToMember(userId, 5, "로그인");
				loginMember.setUserPoint(loginMember.getUserPoint()+5);
				
				HttpSession ses = request.getSession();
				ses.setAttribute("loginUser", loginMember); // 세션에 바인딩
				
				request.getRequestDispatcher("../index.jsp").forward(request, response);
			} else {
				mf.setRedirect(true);
				mf.setWhereIsGo("./login.jsp?status=fail");
			}
			
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("errorStack", e.getStackTrace());
			RequestDispatcher rd = request.getRequestDispatcher("../commonError.jsp"); 
			rd.forward(request, response);

		}

		return mf;
	}

}
