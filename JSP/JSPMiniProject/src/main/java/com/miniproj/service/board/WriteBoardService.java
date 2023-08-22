package com.miniproj.service.board;

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

import com.miniproj.controller.BoardFactory;
import com.miniproj.dao.BoardCRUD;
import com.miniproj.dao.BoardDAO;
import com.miniproj.etc.UploadedFile;
import com.miniproj.service.BoardService;
import com.miniproj.vo.Board;

public class WriteBoardService implements BoardService {

	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 5; // 하나의 파일블럭의 버퍼 사이즈 5MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 최대 파일 사이즈 10MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 15; // 최대 request 사이즈 15MB

	@Override
	public BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardFactory bf = BoardFactory.getInstance();

		String uploadDir = "\\uploads";
		// 실제 파일이 저장될 물리적 경로(서버의 경로가 바뀌어도.. 바뀐 물리적 경로를 얻어오게 된다)
		String realPath = request.getSession().getServletContext().getRealPath(uploadDir);

		System.out.println(realPath);

		String encoding = "utf-8"; // 인코딩 방식
		File saveFileDir = new File(realPath); // 파일이 실제 저장될 경로에 대한 파일 객체 생성

		String writer = "";
		String title = "";
		String content = "";

		// 파일이 저장될 공간의 경로, 사이즈 등의 환경설정 정보를 가지고 있는 객체
		DiskFileItemFactory factory = new DiskFileItemFactory(MEMORY_THRESHOLD, saveFileDir);

		// 실제 request로 넘겨져온 매개변수를 통해 파일을 upload 처리 할 객체
		ServletFileUpload sfu = new ServletFileUpload(factory);
		UploadedFile uf = null;

		try {
			List<FileItem> lst = sfu.parseRequest(request);

			for (FileItem item : lst) {
				System.out.println(item.toString());
				if (item.isFormField()) { // 파일이 아닌 일반 데이터이다
					if (item.getFieldName().equals("writer")) {
						writer = item.getString(encoding);
					} else if (item.getFieldName().equals("title")) {
						title = item.getString(encoding);
					} else if (item.getFieldName().equals("content")) {
						content = item.getString(encoding);
					}
				} else if (item.isFormField() == false && item.getName() != "") { // 업로드된 파일인 경우
					// 1) 중복되지 않을 새 이름으로 저장.

					uf = getNewFileName(item, realPath, writer);
					File uploadFile = new File(realPath + File.separator + uf.getNewFileName());

					item.write(uploadFile);
					uf.setBase64String(makeImgtoBase64String(realPath + File.separator + uf.getNewFileName()));

				}

			}
		} catch (Exception e) {
			// 파일이 업로드 될 때, 저장될 때, 나올 수 있는 기타 모든 예외
			e.printStackTrace();
		}


		// 본문에 줄바꿈이 있다면 줄바꿈 처리를 해야 한다.
		content = content.replace("\r\n", "<br />");
		
		
		Board tmpBoard = new Board(-1, writer, title, null, new StringBuilder(content), -1, -1, -1, -1, -1);

		// DAO단 호출
		BoardDAO dao = BoardCRUD.getInstance();
		
		
		int result = -1;
		try {
			if (uf != null) { // 업로드 파일이 있다.
				result = dao.insertBoardWithUploadFileTransaction(tmpBoard, uf);
			} else if(uf==null){ // 업로드 파일이 없다.
				result = dao.insertBoardTransaction(tmpBoard); // 직접 해보세요
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
		if (result == 0) {
			System.out.println("저장 성공");
		}
		
		bf.setRedirect(true);
		bf.setWhereisGo("listAll.bo");

		return bf;
	}

	private UploadedFile getNewFileName(FileItem item, String realPath, String writer) {
		String uuid = UUID.randomUUID().toString();

		String originalFileName = item.getName(); // 업로드 된 원본 이름
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));

		String newFileName = "";
		if (item.getSize() > 0) {
			// 파일 이름이 중복되지 않게 처리하기 위해 아래처럼 처리하자
			// 예) "userId_UUID.확장자";
			newFileName += writer + "_" + uuid + ext;

		}

		UploadedFile uf = new UploadedFile(originalFileName, ext, newFileName, item.getSize());

		return uf;
	}

	private String makeImgtoBase64String(String uploadedFile) {
		System.out.println(uploadedFile);

		// base64 문자열 : 이진데이터파일을 읽어서 A-Za-z0-9+ / 문자의 조합으로 바꾼것
		// 인코딩
		String result = null;
		File upFile = new File(uploadedFile);
		try {
			byte[] file = FileUtils.readFileToByteArray(upFile); // 업로드된 파일을 읽어 byte[]로 바꿔줌
			result = Base64.getEncoder().encodeToString(file); // 인코딩된 베이스64문자열
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
