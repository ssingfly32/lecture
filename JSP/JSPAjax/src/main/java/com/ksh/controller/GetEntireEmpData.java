package com.ksh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksh.dao.EmployeeCRUD;
import com.ksh.vo.Employee;

/**
 * Servlet implementation class GetEntireEmpData
 */
@WebServlet("/getEmp.do")
public class GetEntireEmpData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeCRUD emp = EmployeeCRUD.getInstance(); // EmployeeCRUD 객체 생성(싱글톤이라 객체는 하나만
		// 생성되고 만들어진 객체를 계속 사용한다.
		try {
			List<Employee> empList = emp.selectAllEmp();
			
			for(Employee e : empList) {
				System.out.println(e.toString());
			}
			
			// 여기부터 다시 코딩 시작
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
