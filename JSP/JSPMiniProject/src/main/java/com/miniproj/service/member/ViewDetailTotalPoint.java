package com.miniproj.service.member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;
import com.miniproj.vo.PointLog;

public class ViewDetailTotalPoint implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		
		MemberDAO dao = MemberCRUD.getInstance();
		int pageNo= 1;
		if(request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals("")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		System.out.println(pageNo + "페이지 글을 출력하자");
		try {
			Member memberInfo = dao.getMemberInfo(userId);
			List<PointLog> lst = dao.getPointLog(userId);
			
			request.setAttribute("memberInfo", memberInfo);
			request.setAttribute("pointLog", lst);

			
			request.getRequestDispatcher("myPage.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
