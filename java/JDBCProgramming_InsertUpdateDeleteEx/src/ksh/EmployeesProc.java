package ksh;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesProc {
	public static void saveEmployees(Connection con) {
		// 
		String query = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 211);
			pstmt.setString(2, "둘리");
			pstmt.setString(3, "고");
			pstmt.setString(4, "DOOLY");
			pstmt.setString(5, "01012345678");
			pstmt.setDate(6, new Date(System.currentTimeMillis()));
			pstmt.setString(7, "IT_PROG");
			pstmt.setFloat(8, 4800.23f);
			pstmt.setFloat(9, .20f);
			pstmt.setInt(10, 132);
			pstmt.setInt(11, 60);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("저장 성공");
				
				pstmt.close();
			}
			
		} catch (SQLException e) {
			if(e.getMessage().indexOf("unique constraint (HR.EMP_EMP_ID_PK)") != -1) {
				System.out.println("사원번호가 중복됩니다!");
			} 
//			else if(e.getMessage().indexOf("integrity constraint")) {
//			해당부서가 없습니다!	
//			}
			e.printStackTrace();
		}
		
		
		
	}

	public static void updateEmployees(Connection con) {
		
		String query = "update employees set commission_pct = ? where employee_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setFloat(1, 0.8f);
			pstmt.setInt(2, 211);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("수정 완료");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void deleteEmployees(Connection con) {
		
		String query = "delete employees where employee_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, 211);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("삭제 완료");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
