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
import com.ksh.vo.Employee;

/**
 * Servlet implementation class SaveEmployeeServlet
 */
@WebServlet("/saveEmp.do")
public class SaveEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json; charset=utf-8;");
		PrintWriter out = resp.getWriter();

		int empNo = Integer.parseInt(req.getParameter("empNo"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		String tmphireDate = req.getParameter("hireDate");
		Date hireDate = Date.valueOf(tmphireDate);
		String jobId = req.getParameter("jobId");
		String tmpSalary = req.getParameter("salary");
		float salary = Float.parseFloat(tmpSalary);
		float comm = Float.parseFloat(req.getParameter("comm"));
		int managerId = Integer.parseInt(req.getParameter("managerId"));
		int deptId = Integer.parseInt(req.getParameter("departmentId"));

		Employee saveEmp = new Employee(empNo, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, comm,
				managerId, deptId, null);

		try {
			int result = EmployeeCRUD.getInstance().updateEmployee(saveEmp);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=utf-8;");
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String tmphireDate = request.getParameter("hireDate");
		Date hireDate = Date.valueOf(tmphireDate);
		String jobId = request.getParameter("jobId");
		String tmpSalary = request.getParameter("salary");
		float salary = Float.parseFloat(tmpSalary);
		float comm = Float.parseFloat(request.getParameter("comm"));
		int managerId = Integer.parseInt(request.getParameter("managerId"));
		int deptId = Integer.parseInt(request.getParameter("departmentId"));

		Employee saveEmp = new Employee(-1, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, comm,
				managerId, deptId, null);

		System.out.println(saveEmp.toString());

		try {
			int result = EmployeeCRUD.getInstance().insertEmployee(saveEmp);

			Map<String, String> jsonMap = new HashMap<String, String>();

			jsonMap.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
			jsonMap.put("responseCode", "00");
			jsonMap.put("responseMsg", ResponseMessageCode.getMessage("00"));

			JSONObject json = new JSONObject(jsonMap);
			out.print(json.toJSONString());

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

	}

}
