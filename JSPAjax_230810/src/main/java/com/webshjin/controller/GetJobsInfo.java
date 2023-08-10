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

import com.google.gson.Gson;
import com.webshjin.dao.GetInfo;
import com.webshjin.etc.ResponseMessageCode;
import com.webshjin.vo.JobsVO;

/**
 * Servlet implementation class GetJobsInfo
 */
@WebServlet("/getJobsInfo.do")
public class GetJobsInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		try {
			List<JobsVO> lst = GetInfo.getInstance().getJobsInfo();
			
			JobsVO job = new JobsVO("prog", "programmer", 5000, 100000);
			
			Gson gson = new Gson();
			
			out.print(gson.toJson(lst));
			
			
			
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
