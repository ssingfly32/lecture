package com.webshjin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.webshjin.vo.Employee;

public class EmployeeCRUD {
	private static EmployeeCRUD instance = null;
	
	private EmployeeCRUD() { }
	
	public static EmployeeCRUD getInstance() {
		if (instance == null) {
			instance = new EmployeeCRUD();
		}
		
		return instance;
	}
	
	public List<Employee> selectAllEmp() throws NamingException, SQLException {
		// 모든 사원 정보를 얻어올꺼야
		
		List<Employee> list = new ArrayList();
		
		DBConnection dbCon = DBConnection.getInstance();
		Connection con = dbCon.dbConnect();
		
		String query = "select e.*, d.department_name "
				+ "from employees e inner join departments d "
				+ "on e.department_id = d.department_id order by employee_id";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { // row 가 있을동안 반복
			list.add(new Employee(
					rs.getInt("EMPLOYEE_ID"),
					rs.getString("FIRST_NAME"),
					rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), 
					rs.getString("PHONE_NUMBER"),
					rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), 
					rs.getFloat("SALARY"), 
					rs.getFloat("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), 
					rs.getInt("DEPARTMENT_ID"),
					rs.getString("DEPARTMENT_NAME")));
			
		}
		
		dbCon.dbClose(rs, pstmt, con);
		
		return list;
	}

	
	public List<Employee> selectByEmpName(String findEmpName) throws NamingException, SQLException {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "select e.*, d.department_name "
				+ "from employees e inner join departments d "
				+ "on e.department_id = d.department_id "
				+ "where lower(e.first_name) like ?";   // '%?%'
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, "%" + findEmpName + "%");
		
		ResultSet resultSet = pstmt.executeQuery();
		while(resultSet.next()) {
			list.add(new Employee(
					resultSet.getInt("EMPLOYEE_ID"),
					resultSet.getString("FIRST_NAME"),
					resultSet.getString("LAST_NAME"),
					resultSet.getString("EMAIL"), 
					resultSet.getString("PHONE_NUMBER"),
					resultSet.getDate("HIRE_DATE"),
					resultSet.getString("JOB_ID"), 
					resultSet.getFloat("SALARY"), 
					resultSet.getFloat("COMMISSION_PCT"),
					resultSet.getInt("MANAGER_ID"), 
					resultSet.getInt("DEPARTMENT_ID"),
					resultSet.getString("DEPARTMENT_NAME")));
		}
		
		DBConnection.getInstance().dbClose(resultSet, pstmt, con);
		
		return list;
	}

	public List<Employee> orderToEmp(String orderMethod) throws NamingException, SQLException {
		List<Employee> list = new ArrayList();
		Connection con = DBConnection.getInstance().dbConnect();
		
		// 동적 SQL : orderMethod의 값에 따라 쿼리문이 달라짐
		// 내용 결합도는 증가하지만 프로그래밍 코드가 직관적이므로 많이 사용된다.
		String query = "select e.*, d.department_name "
				+ "from employees e inner join departments d "
				+ "on e.department_id = d.department_id "
				+ "order by ";
		
		if (orderMethod.equals("empNo")) {
			query += "employee_id";
		} else if(orderMethod.equals("hiredate")) {
			query += "hire_date desc";
		} else if(orderMethod.equals("salary")) {
			query += "salary desc";
		}
		
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { // row 가 있을동안 반복
			list.add(new Employee(
					rs.getInt("EMPLOYEE_ID"),
					rs.getString("FIRST_NAME"),
					rs.getString("LAST_NAME"),
					rs.getString("EMAIL"), 
					rs.getString("PHONE_NUMBER"),
					rs.getDate("HIRE_DATE"),
					rs.getString("JOB_ID"), 
					rs.getFloat("SALARY"), 
					rs.getFloat("COMMISSION_PCT"),
					rs.getInt("MANAGER_ID"), 
					rs.getInt("DEPARTMENT_ID"),
					rs.getString("DEPARTMENT_NAME")));
			
		}
		
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		
		return list;
		
	}

	public int insertEmployee(Employee saveEmp) throws NamingException, SQLException {
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		// 저장프로시저를 DB에 만들고, 그 프로시저를 CallableStatement를 이용하여 호출해보자.
		String query = "{call SAVEEMPLOYEE(?,?,?,?,?,?,?,?,?,?,?)}";
		
		CallableStatement cstmt = con.prepareCall(query);
		
		cstmt.setString(1, saveEmp.getFirst_name());
		cstmt.setString(2, saveEmp.getLast_name());
		cstmt.setString(3, saveEmp.getEmail());
		cstmt.setString(4, saveEmp.getPhone_number());
		cstmt.setDate(5, saveEmp.getHire_date());
		cstmt.setString(6, saveEmp.getJob_id());
		cstmt.setFloat(7, saveEmp.getSalary());
		cstmt.setFloat(8, saveEmp.getCommission_pct());
		cstmt.setInt(9, saveEmp.getManager_id());
		cstmt.setInt(10, saveEmp.getDepartment_id());
		
		// 마지막 매개변수는 out 매개변수
		cstmt.registerOutParameter(11, java.sql.Types.INTEGER);
		
		cstmt.executeUpdate(); // 실행
		
		// out매개변수에서 반환한 값을 가져오기
		int result = cstmt.getInt(11);
		
		System.out.println(result);
		
		DBConnection.getInstance().dbClose(cstmt, con);
		
		return result;
		
	}

	public int deleteEmp(int empNo) throws NamingException, SQLException {
		int result = -1;
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "delete from employees where employee_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, empNo);
		
		result = pstmt.executeUpdate();
		
		DBConnection.getInstance().dbClose(pstmt, con);
		
		return result;
		
	}
}
