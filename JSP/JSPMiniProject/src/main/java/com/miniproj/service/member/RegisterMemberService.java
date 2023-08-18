package com.miniproj.service.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.etc.UploadedFile;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;

public class RegisterMemberService implements MemberService {

	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 5;	// 하나의 파일블럭의 버퍼 사이즈 5MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;	// 최대 파일 사이즈 10MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 15;	// 최대 request 사이즈 15MB
	
	
	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입하자");
		
		// 파일과 함께 데이터를 받았다면 request.getParameter()로 데이터를 수집하면 안된다.(!)
		String uploadDir = "\\memberImg";
		// 실제 파일이 저장될 물리적 경로(서버의 경로가 바뀌어도.. 바뀐 물리적 경로를 얻어오게 된다)
		String realPath = request.getSession().getServletContext().getRealPath(uploadDir);
		
		System.out.println(realPath);
		
		String encoding = "utf-8";	// 인코딩 방식
		
		File saveFileDir = new File(realPath);	// 파일이 실제 저장될 경로에 대한 파일 객체 생성
		
		String userId = "";
		String userPwd = "";
		String email = "";
		String userImg = "";
		
		// 파일이 저장될 공간의 경로, 사이즈 등의 환경설정 정보를 가지고 있는 객체
		DiskFileItemFactory factory = new DiskFileItemFactory(MEMORY_THRESHOLD, saveFileDir);
		
		// 실제 request로 넘겨져온 매개변수를 통해 파일을 upload 처리 할 객체
		ServletFileUpload sfu = new ServletFileUpload(factory);
		UploadedFile uf = null;
		try {
			List<FileItem> lst = sfu.parseRequest(request);
			
			for (FileItem item : lst) {
//				System.out.println(item);
				/*
				 * FileItem 속성에서 
					1) name 값이 null이 아니면 file
					2) 파일이면 name 속성의 값이 업로드된 파일이름(확장자)
					3) isFormField의 값이 true 이면 파일이 아닌 데이터. 반대로 false이면 파일
					4) FieldName의 값이 보내온 데이터의 input태그의 name 속성값
				 * 
				 * */
				
				
				if(item.isFormField()) {	// 파일이 아닌 일반 데이터이다
					if(item.getFieldName().equals("userId")) {
						userId = item.getString(encoding);
					} else if(item.getFieldName().equals("userPwd")) {
						userPwd = item.getString(encoding);
					} else if(item.getFieldName().equals("userEmail")) {
						email = item.getString(encoding);
					}
				} else if(item.isFormField() == false && item.getName() != "") { // 업로드된 파일인 경우
					// 파일을 저장해야 하는데 파일의 이름이 중복되는 경우가 있기 때문에...
					// 아래의 처리를 한다
					
					// 1) 중복되지 않을 새 이름으로 저장.
					 
						
						uf = getNewFileName(item,realPath, userId);
					
					
					// 2) 파일명(순서).확장자로 새파일이름을 만들고 싶은 경우
					
					File uploadFile = new File(realPath + File.separator+ uf.getNewFileName());
					try {
						item.write(uploadFile);
					} catch (Exception e) {
						// 업로드 된 파일이 실제 저장될 때 예외
						e.printStackTrace();
					}
					
				}
			}
		
		} catch (FileUploadException e) {
			/// 파일이 업로드 될 때 예외 발생
			e.printStackTrace();
		} 
		
		MemberDAO mdao = MemberCRUD.getInstance();
		int result = -1;
		try {
			if(uf != null) {	// 업로드된 파일이 있는 경우
				uf.setNewFileName("memberImg/" + uf.getNewFileName());
				result = mdao.registerMemberWithFile(uf, new Member(userId, userPwd, email, null, -1, -1), "회원가입", 100);
				
				
				
			} else {	// 업로드된 파일이 없는 경우
				result = mdao.registermember(new Member(userId, userPwd, email, null, -1, -1), "회원가입", 100);
			}
			if(result == 0) {
				System.out.println("회원가입 성공!!");
			}
		} catch(NamingException | SQLException e) {
			// DB에 저장할 때 나오는 예외
			e.printStackTrace();
			
			// 1) 업로드된 파일이 있다면 지워야 합니다.
			if(uf!=null) {
				System.out.println(uf.toString());
				String without = uf.getNewFileName().substring("memberImg/".length());
				System.out.println(without);
				File deleteFile = new File(realPath + File.separator+without);
				deleteFile.delete();
			}
		}
		return null;
		
	}


	private UploadedFile getNewFileName(FileItem item, String realPath, String userId) {
		String uuid = UUID.randomUUID().toString();
		
		String originalFileName = item.getName();	// 업로드 된 원본 이름
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String newFileName = "";
		if(item.getSize() > 0) {
			// 파일 이름이 중복되지 않게 처리하기 위해 아래처럼 처리하자
			// 예) "userId_UUID.확장자";
			newFileName += userId + "_" + uuid + ext;
			
		}
		
		
		UploadedFile uf = new UploadedFile(originalFileName, ext, newFileName, item.getSize());
		System.out.println(uf.toString());
		
		return uf;
	}

}
