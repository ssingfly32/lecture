package com.ksh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ksh.vo.Employee;

public class EmployeeCRUD { // 싱글톤
	private static EmployeeCRUD instance = null;
	
	private EmployeeCRUD() {}
	
	public static EmployeeCRUD getInstance() {
		if (instance == null) {
			instance = new EmployeeCRUD();
		}
		return instance;
	}
	
	public List<Employee> selectAllEmp() throws NamingException, SQLException {
		// 모든 사원 정보를 얻어올 것이다.
		
		List<Employee> list = new ArrayList<Employee>(); // new 뒤에 오브임플로이 생략 가능
		
		DBConnection dbCon = DBConnection.getInstance(); 
		Connection con = dbCon.dbConnect(); 
		
		String query = "select e.*, d.department_name from employees e inner join departments d "
				+ "on e.department_id = d.department_id";
		
		
		//매개변수화된 SQL 문을 데이터베이스로 전송하기 위한 PreparedStatement 객체를 만듭니다.
		PreparedStatement pstmt = con.prepareStatement(query); 
		
		// 이 PreparedStatement 객체에서 SQL 쿼리를 실행하고 쿼리에 의해 생성된 ResultSet 객체를 반환합니다.
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { // row가 있을동안 반복
			list.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"), 
					rs.getDate("HIRE_DATE"), rs.getString("JOB_ID"), rs.getFloat("SALARY"), rs.getFloat("COMMISSION_PCT"), rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID"), rs.getString("DEPARTMENT_NAME")));
		}
		
		dbCon.dbClose(rs, pstmt, con);
		
		return list;
	}

	public List<Employee> selectByEmpName(String findEmpName) throws NamingException, SQLException {
		List<Employee> list = new ArrayList<Employee>();
		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select e.*, d.department_name from employees e inner join departments d "
				+ "on e.department_id = d.department_id where lower(e.first_name) like ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, "%"+findEmpName +"%");
		
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) { // row가 있을동안 반복
			list.add(new Employee(resultSet.getInt("EMPLOYEE_ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), 
					resultSet.getString("EMAIL"), resultSet.getString("PHONE_NUMBER"), 
					resultSet.getDate("HIRE_DATE"), resultSet.getString("JOB_ID"), resultSet.getFloat("SALARY"), 
					resultSet.getFloat("COMMISSION_PCT"), resultSet.getInt("MANAGER_ID"), resultSet.getInt("DEPARTMENT_ID"), 
					resultSet.getString("DEPARTMENT_NAME")));
		}
		DBConnection.getInstance().dbClose(resultSet, pstmt, con);
		return list;
	}
	
	public Employee selectByEmpNo(String findEmpNo) throws NamingException, SQLException {
		Employee emp = null;
		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select e.*, d.department_name from employees e inner join departments d on e.department_id = d.department_id where employee_id = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, findEmpNo);
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			emp = new Employee(resultSet.getInt("EMPLOYEE_ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"), 
					resultSet.getString("EMAIL"), resultSet.getString("PHONE_NUMBER"), 
					resultSet.getDate("HIRE_DATE"), resultSet.getString("JOB_ID"), resultSet.getFloat("SALARY"), 
					resultSet.getFloat("COMMISSION_PCT"), resultSet.getInt("MANAGER_ID"), resultSet.getInt("DEPARTMENT_ID"), 
					resultSet.getString("DEPARTMENT_NAME"));
		}
		
		return emp;
		
	}
}
 