package ksh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

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
		
		if(con != null) {
			System.out.println("DB 연결 성공 : " + con.toString());
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("DB 접속 해제 실패");
		}
	}

}
