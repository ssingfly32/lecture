package com.miniproj.service.member;

import java.io.File;
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

public class DefaultImageService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession ses = request.getSession();
		Member loginUser = (Member)ses.getAttribute("loginUser");
		int userImg = loginUser.getUserImg();
		String userId = loginUser.getUserId();
		String memberImg = loginUser.getMemberImg();
		String uploadDir = "\\memberImg";
		String realPath = request.getSession().getServletContext().getRealPath(uploadDir);
		MemberDAO mdao = MemberCRUD.getInstance();
		if(userImg != 1) {
			System.out.println("유저이미지 존재하니 초기화 작업 하겠습니다.");
			try {
				int result = mdao.defaultImage(userId, userImg);
				if(result == 1) {
					
					String without = memberImg.substring("memberImg/".length());
					System.out.println(without);
					File deleteFile = new File(realPath + File.separator+without);
					deleteFile.delete();
					System.out.println(without + "폴더에서 이미지 삭제 완료");
					
					loginUser.setUserImg(1);
					loginUser.setMemberImg("memberImg/user.png");
					request.setAttribute("loginUser", loginUser);
					request.getRequestDispatcher("myPage.mem?userId=" + userId).forward(request, response);
//					response.sendRedirect("myPage.mem?userId=" + userId);
				}
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
//		mdao.defaultImage(userId);
		return null;
		
		
	}

}
