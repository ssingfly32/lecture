package ksh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DMLTest {

	public static void main(String[] args) {
		String id = "hr";
		String password = "1234";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection con = null;

		try {
			// "oracle.jdbc.driver.OracleDriver" 클래스를 메모리로 로딩
			// Class.forName() : 클래스나 인터페이스의 로더(loader)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}

		if (con != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"1. insert / 2. update, 3. delete 4.부서추가 5.부서수정 6.부서삭제 >>> ");
			switch (sc.nextInt()) {
			case 1:
				EmployeesProc.saveEmployees(con);
			case 2:
				EmployeesProc.updateEmployees(con);
			case 3:
				EmployeesProc.deleteEmployees(con);
			case 4:
				DepartmentsProc.saveDepartments(con);
			case 5:
				DepartmentsProc.updateDepartments(con);
			case 6:
				DepartmentsProc.deleteDepartments(con);
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
