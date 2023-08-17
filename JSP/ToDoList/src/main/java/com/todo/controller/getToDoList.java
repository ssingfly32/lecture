package com.todo.controller;

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


import com.todo.etc.ResponseMessageCode;
import com.todo.etc.ResponseToJSON;

import com.todo.dao.TodoCRUD;
import com.todo.vo.ToDoList;

/**
 * Servlet implementation class getToDoList
 */
@WebServlet("/getToDo.do")
public class getToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		TodoCRUD tc = TodoCRUD.getInstance(); // EmployeeCRUD 객체 생성(싱글톤이라 객체는 하나만
		// 생성되고 만들어진 객체를 계속 사용한다.
		try {
			List<ToDoList> empList = tc.selectAllEmp();

			ResponseToJSON rt = new ResponseToJSON();
			String jsonStr = rt.makeJsonWithSimpleJson(empList);
			out.print(jsonStr); // PrintWriter 객체는 스트림 출력 객체(문자열 싣고 가서 출력해준다)
			
			
			
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
