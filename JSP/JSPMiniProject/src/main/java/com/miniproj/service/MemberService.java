package com.miniproj.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.MemberFactory;

public interface MemberService {
	MemberFactory executeService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
