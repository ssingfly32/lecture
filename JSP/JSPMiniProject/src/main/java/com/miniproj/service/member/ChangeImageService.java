package com.miniproj.service.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.etc.UploadedFile;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;

public class ChangeImageService implements MemberService {
	
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 5;	// 하나의 파일블럭의 버퍼 사이즈 5MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;	// 최대 파일 사이즈 10MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 15;	// 최대 request 사이즈 15MB
	

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession();
		Member loginUser = (Member)ses.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		// 파일과 함께 데이터를 받았다면 request.getParameter()로 데이터를 수집하면 안된다.(!)
				String uploadDir = "\\memberImg";
				// 실제 파일이 저장될 물리적 경로(서버의 경로가 바뀌어도.. 바뀐 물리적 경로를 얻어오게 된다)
				String realPath = request.getSession().getServletContext().getRealPath(uploadDir);
				
				System.out.println(realPath);
				
				String encoding = "utf-8";	// 인코딩 방식
				
				File saveFileDir = new File(realPath);	// 파일이 실제 저장될 경로에 대한 파일 객체 생성
				
				
				
				// 파일이 저장될 공간의 경로, 사이즈 등의 환경설정 정보를 가지고 있는 객체
				DiskFileItemFactory factory = new DiskFileItemFactory(MEMORY_THRESHOLD, saveFileDir);
				
				// 실제 request로 넘겨져온 매개변수를 통해 파일을 upload 처리 할 객체
				ServletFileUpload sfu = new ServletFileUpload(factory);
				UploadedFile uf = null;
		
		
		MemberDAO dao = MemberCRUD.getInstance();
		try {
			dao.changeImage(userId);
			System.out.println(userId);
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
