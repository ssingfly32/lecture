package com.miniproj.service.member;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
import com.miniproj.vo.PointLog;

public class LoginMemberService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String why = "로그인";
//		String when = request.getParameter("when");
//		System.out.println(when);
		MemberFactory mf = MemberFactory.getInstance();
		
		MemberDAO dao = MemberCRUD.getInstance();
//		long loginPoint = Long.parseLong(request.getParameter("when"));
//		Date LastLoginPoint = new Date(loginPoint);
//		System.out.println(loginPoint);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Timestamp curDate = new Timestamp(System.currentTimeMillis());
		
		try {
			Member loginMember = dao.loginMember(userId, userPwd);
			
			if (loginMember != null) { // 로그인 성공
				// member 테이블 update + 포인트 로그 남기기
				// 하루에 한 번씩만 로그인 포인트 적립 가능
				// 로그인이라는 why가 존재하는지 먼저 조회 (트랜잭션 처리 필요)
				
				if(dao.DailyLoginPoint(userId, why) != null) { // 로그인 포인트 있을 때
					
					PointLog pl = dao.DailyLoginPoint(userId, why);
					if(!sdf.format(pl.getWhen()).equals(sdf.format(curDate))) { // 하루 한 번
					dao.addPointToMember(userId, 5, "로그인");
					loginMember.setUserPoint(loginMember.getUserPoint()+5);
					}
				} else {
					dao.addPointToMember(userId, 5, "로그인");
					loginMember.setUserPoint(loginMember.getUserPoint()+5);
				}
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
