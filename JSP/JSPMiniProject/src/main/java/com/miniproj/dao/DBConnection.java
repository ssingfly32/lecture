package com.miniproj.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection { // 싱글톤
	private static DBConnection instance = null;
	
	private DBConnection() { }
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		
		return instance;
	}
	
	// DataBase 커넥션 객체를 반환하는 메서드
	public Connection dbConnect() throws NamingException, SQLException {
		Context initContext = new InitialContext();
		// 디렉토리 서비스에 의해 context.xml 파일의 객체를 얻어와(JNDI)
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("MySql");
		Connection conn = ds.getConnection();
		
//		System.out.println(conn.toString());
		
		return conn;
	}
	
	public void dbClose(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		rs.close();
		stmt.close();
		con.close();
	}
	
	public void dbClose(Statement stmt, Connection con) throws SQLException {
		stmt.close();
		con.close();
	}
}
