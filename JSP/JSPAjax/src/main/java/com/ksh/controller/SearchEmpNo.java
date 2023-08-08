package com.ksh.controller;

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

import com.ksh.dao.EmployeeCRUD;
import com.ksh.etc.ResponseMessageCode;
import com.ksh.etc.ResponseToJSON;
import com.ksh.vo.Employee;

/**
 * Servlet implementation class SearchEmpNo
 */
@WebServlet("/findEmpByNo.do")
public class SearchEmpNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String findEmpNo = request.getParameter("empNo");
		
		
		try {
			Employee e = EmployeeCRUD.getInstance().selectByEmpNo(findEmpNo);
			ResponseToJSON rt = new ResponseToJSON();
			String jsonStr = rt.makeJsonWithSimpleJson(e);
			out.print(jsonStr);
		} catch (NamingException |  SQLException e) {
			e.printStackTrace();
			Map<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("count", "0");
			jsonMap.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
			jsonMap.put("responseCode", "01");
			jsonMap.put("responseMsg", ResponseMessageCode.getMessage("01"));
			jsonMap.put("exceptionMsg", e.getMessage());
			
			JSONObject json = new JSONObject(jsonMap);
			out.print(json.toJSONString());
		} catch (NullPointerException e) {
			e.printStackTrace();
			Map<String, String> jsonMap = new HashMap<String, String>();
			jsonMap.put("count", "0");
			jsonMap.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
			jsonMap.put("responseCode", "04");
			jsonMap.put("responseMsg", ResponseMessageCode.getMessage("04"));
			jsonMap.put("exceptionMsg", e.getMessage());
			
			JSONObject json = new JSONObject(jsonMap);
			out.print(json.toJSONString());
		}
		out.flush();
		out.close();
		}
	}


