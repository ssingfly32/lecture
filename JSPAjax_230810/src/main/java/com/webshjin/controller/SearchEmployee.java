package com.webshjin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
import com.webshjin.etc.ResponseToJSON;
import com.webshjin.vo.Employee;

/**
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/findEmpByName.do")
public class SearchEmployee extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String findEmpName = request.getParameter("empName");
		System.out.println(findEmpName);
		
		try {
			List<Employee> lst = EmployeeCRUD.getInstance().selectByEmpName(findEmpName);
			
			ResponseToJSON 의미있게아무거나 = new ResponseToJSON();
			String jsonStr = 의미있게아무거나.makeJsonWithSimpleJson(lst);
			
			out.print(jsonStr);
			
			
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
