package com.miniproj.service.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.miniproj.controller.MemberFactory;
import com.miniproj.dao.MemberCRUD;
import com.miniproj.dao.MemberDAO;
import com.miniproj.service.MemberService;
import com.miniproj.vo.Member;

public class DuplicateUserIdService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("아이디 중복인지 아닌지 검사하자!");
		
		String tmpUserId = request.getParameter("tmpUserId");
		
		MemberDAO mdao = MemberCRUD.getInstance();
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Map<String, String> jsonMap = new HashMap<String,String>();
		try {
			Member mem = mdao.duplicateUserId(tmpUserId);
			
			if(mem != null) {
				// 아이디가 중복이다
				jsonMap.put("isDuplicate", "true");
				
			} else if (mem == null) {
				// 아이디가 중복 아니다
				jsonMap.put("isDuplicate", "false");
			}
			jsonMap.put("responseCode", "00");
			jsonMap.put("createdTime", new java.util.Date(System.currentTimeMillis()).toString());
			
			
			
		} catch (NamingException | SQLException e) {
			// 공통 예외처리 필요
			e.printStackTrace();
			jsonMap.put("responseCode", "err");
			jsonMap.put("errMsg", e.getMessage());
			
		}
		
		JSONObject json = new JSONObject(jsonMap);
		out.print(json.toJSONString());
		out.flush();
		out.close();
		
		// 반환값 타입인 MemberFactory 값을 null을 반환한 이유 (이미 json으로 응답처리를 완료 했기 때문)
		return null; 
	}

}
