package com.miniproj.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.BoardFactory;

public interface BoardService {
	BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
	
}
