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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.webshjin.dao.EmployeeCRUD;
import com.webshjin.etc.ResponseMessageCode;
import com.webshjin.etc.ResponseToJSON;
import com.webshjin.vo.Employee;

/**
 * Servlet implementation class GetEntireEmpData
 */
@WebServlet("/getEmp.do")
public class GetEntireEmpData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		EmployeeCRUD emp = EmployeeCRUD.getInstance();
		try {
			List<Employee> empList = emp.selectAllEmp();

			ResponseToJSON 의미있게아무거나 = new ResponseToJSON();
			String jsonStr = 의미있게아무거나.makeJsonWithSimpleJson(empList);
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
