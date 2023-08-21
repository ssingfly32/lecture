package com.miniproj.service.member;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
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
import org.apache.commons.io.FileUtils;

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
		
		MemberFactory mf = MemberFactory.getInstance();
		
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
						
//					uf = makeNewFileNameWithNumbering(item, realPath);
					
					File uploadFile = new File(realPath + File.separator+ uf.getNewFileName());
					try {
						item.write(uploadFile);
					} catch (Exception e) {
						// 업로드 된 파일이 실제 저장될 때 예외
						e.printStackTrace();
						
						mf.setRedirect(true);
						mf.setWhereIsGo(request.getContextPath()+"/member/register.jsp?status=fail");
						
						return mf;
					}
					
					// 만약 이미지 파일을 따로 저장하지 않고 base64문자열로 처리하여 저장하고 싶다면..
					makeImgtoBase64String(realPath + File.separator+ uf.getNewFileName());
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
			mf.setRedirect(true);
			mf.setWhereIsGo(request.getContextPath() + "/member/register.jsp?status=fail");
			
			
			
			return mf;
		}
		
		mf.setRedirect(true);
		mf.setWhereIsGo(request.getContextPath() + "/index.jsp?status=success");
		
		
		
		return mf;
		
	}
	
	private void makeImgtoBase64String(String uploadedFile) {
		System.out.println(uploadedFile);
		
		// base64 문자열 : 이진데이터파일을 읽어서 A-Za-z0-9+ / 문자의 조합으로 바꾼것
		// 인코딩
		String result = null;
		File upFile = new File(uploadedFile);
		try {
			byte[] file = FileUtils.readFileToByteArray(upFile);	// 업로드된 파일을 읽어 byte[]로 바꿔줌
			result = Base64.getEncoder().encodeToString(file);	// 인코딩된 베이스64문자열
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String realPath = "D:\\lecture\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JSPMiniProject\\memberImg";
		
		// 디코딩 (문자열 -> 파일)
		String encodedStr = "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";
		byte[] encodedArr = Base64.getDecoder().decode(encodedStr);
		File f = new File(realPath + File.separator+ "aaaaaa.png");
		try {
			FileUtils.writeByteArrayToFile(f, encodedArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UploadedFile uf = new UploadedFile() ?
		// return result;
	}

	private UploadedFile makeNewFileNameWithNumbering(File item, String realPath) {
		String originalFileName = item.getName();	// 업로드 된 원본 이름
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		// ex) abc.jpg -> abc(1).jpg -> abc(2).jpg -> abc(3).jpg
		// 직접 해보세요
		while(duplicateFileName(originalFileName, realPath)) {
			
		}
		return null;
	}

	private boolean duplicateFileName(String originalFileName, String realPath) {
		boolean result = false;
		
		File realPathFile = new File(realPath);
		for (File f : realPathFile.listFiles()) {
			if(f.getName().equals(originalFileName)) {
				result = true;
			}
		}
		
		return result;
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
