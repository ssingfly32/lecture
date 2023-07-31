package ksh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchEmployees {
	public static void searchByEmpNo(Connection con) {
		// 사번으로 조회
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 사원의 번호 >>> ");
		int empNo = sc.nextInt();
		
		// 실행될 쿼리문
		String query = "select * from employees where employee_id = " + empNo;
		
		// Statement : static SQL 문장을 실행하고 그 결과를 반환하는 역할을 하는 객체
		// Statement 인터페이스를 사용하여 SQL문을 실행하는 방법은 SQL Injection 공격에 ****************취약***********하다.
		// PreparedStatement 인터페이스(주어진 SQL문을 preCompile함(쿼리문이 먼저 실행이됨))를 사용해야 한다.
		try {
			Statement stmt = con.createStatement();
			// query문(select)을 실행하고 결과를 ResultSet 객체에 담아옴
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) { // query문의 실행 결과의 row가 있을 동안 반복
				System.out.println(rs.getInt("EMPLOYEE_ID") + "/" +
						rs.getString("FIRST_NAME") + "/" +
						rs.getString("LAST_NAME") + "/" +
						rs.getString("EMAIL") + "/" +
						rs.getString("PHONE_NUMBER") + "/" +
						rs.getDate("HIRE_DATE") + "/" +
						rs.getString("JOB_ID") + "/" +
						rs.getFloat("SALARY") + "/" +
						rs.getFloat("COMMISSION_PCT") + "/" +
						rs.getInt("MANAGER_ID") + "/" +
						rs.getInt("DEPARTMENT_ID") + "/");
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void searchByEmpName(Connection con) {
		// 이름으로 조회
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 사원의 이름 >>> ");
		String empName = sc.next();
		
		String query = "select * from employees where first_name = initcap(?)";
		
		// PreparedStatement 생성
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query); // query문 preCompile
			pstmt.setString(1, empName); // 파라메터가 세팅 (1=첫번째 물음표)
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { // query문의 실행 결과의 row가 있을 동안 반복
				System.out.println(rs.getInt("EMPLOYEE_ID") + "/" +
						rs.getString("FIRST_NAME") + "/" +
						rs.getString("LAST_NAME") + "/" +
						rs.getString("EMAIL") + "/" +
						rs.getString("PHONE_NUMBER") + "/" +
						rs.getDate("HIRE_DATE") + "/" +
						rs.getString("JOB_ID") + "/" +
						rs.getFloat("SALARY") + "/" +
						rs.getFloat("COMMISSION_PCT") + "/" +
						rs.getInt("MANAGER_ID") + "/" +
						rs.getInt("DEPARTMENT_ID") + "/");
			} 
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void searchByAllEmployees(Connection con) {
		//전체 사원 조회
		String query = "select * from employees";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { // query문의 실행 결과의 row가 있을 동안 반복
				System.out.println(rs.getInt("EMPLOYEE_ID") + "/" +
						rs.getString("FIRST_NAME") + "/" +
						rs.getString("LAST_NAME") + "/" +
						rs.getString("EMAIL") + "/" +
						rs.getString("PHONE_NUMBER") + "/" +
						rs.getDate("HIRE_DATE") + "/" +
						rs.getString("JOB_ID") + "/" +
						rs.getFloat("SALARY") + "/" +
						rs.getFloat("COMMISSION_PCT") + "/" +
						rs.getInt("MANAGER_ID") + "/" +
						rs.getInt("DEPARTMENT_ID") + "/");
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
