package ksh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectEx {

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
		
		Scanner sc = new Scanner(System.in);
		
		if(con != null) {
			System.out.println("사원 조회 (1.사번으로 조회, 2. 이름으로 사원 조회, 3. 전체사원 조회) >>> ");
			switch(sc.nextInt()) {
				case 1:
					SearchEmployees.searchByEmpNo(con);
					break;
				case 2:
					SearchEmployees.searchByEmpName(con);
					break;
				case 3:
					SearchEmployees.searchByAllEmployees(con);
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
