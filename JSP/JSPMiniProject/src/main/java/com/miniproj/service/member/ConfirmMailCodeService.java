package com.miniproj.service.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.miniproj.controller.MemberFactory;
import com.miniproj.service.MemberService;

public class ConfirmMailCodeService implements MemberService {

	@Override
	public MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userInputMailCode = request.getParameter("tmpMailCode");
		String code = (String)request.getSession().getAttribute("authCode");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JSONObject json = new JSONObject();
		
		if(userInputMailCode.equals(code)) {
			json.put("activation", "success");
		} else {
			
			json.put("activation", "fail");
		}
		out.print(json.toJSONString());
		out.flush();
		out.close();
		return null;
	}

}
