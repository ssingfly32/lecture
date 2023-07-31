package ksh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentsProc {
	// 부서 테이블 추가,수정,삭제
	 
	public static void saveDepartments(Connection con) {
		String query = "insert into departments values(?,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 333);
			pstmt.setString(2, "SH");
			pstmt.setInt(3, 207);
			pstmt.setInt(4, 1700);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("저장 완료");
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateDepartments(Connection con) {
		String query = "update departments set department_name = ? where department_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "KSH");
			pstmt.setInt(2, 333);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("수정 완료");
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteDepartments(Connection con) {
		String query = "delete from departments where department_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 333);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("삭제 완료");
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
