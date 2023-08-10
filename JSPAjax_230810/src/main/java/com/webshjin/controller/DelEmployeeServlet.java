package com.webshjin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.webshjin.dao.EmployeeCRUD;
import com.webshjin.etc.ResponseMessageCode;

/**
 * Servlet implementation class DelEmployeeServlet
 */
@WebServlet("/delEmp.do")
public class DelEmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		int empNo = Integer.parseInt(request.getParameter("delEmpNo"));
		System.out.println(empNo);
		
		try {
			int result = EmployeeCRUD.getInstance().deleteEmp(empNo);
			
			if (result == 1) {
				Map<String, String> jsonMap = new HashMap<String, String>();
				
				jsonMap.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
				jsonMap.put("responseCode", "00");
				jsonMap.put("responseMsg", ResponseMessageCode.getMessage("00"));
				
				JSONObject json = new JSONObject(jsonMap);
				out.print(json.toJSONString());
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			
			Map<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("count", "0");
			jsonMap.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
			jsonMap.put("responseCode", "01");
			jsonMap.put("responseMsg", ResponseMessageCode.getMessage("01"));
			jsonMap.put("exceptionMsg", e.getMessage());
			
			
			
			JSONObject json = new JSONObject(jsonMap);
			out.print(json.toJSONString());
		}
		
		out.flush();
		out.close();
	}

}
