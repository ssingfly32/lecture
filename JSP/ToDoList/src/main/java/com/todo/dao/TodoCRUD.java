package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.todo.vo.ToDoList;



public class TodoCRUD {
private static TodoCRUD instance = null;
	
	private TodoCRUD() { }
	
	public static TodoCRUD getInstance() {
		if (instance == null) {
			instance = new TodoCRUD();
		}
		
		return instance;
	}
	
	public List<ToDoList> selectAllEmp() throws NamingException, SQLException {
		// 모든 사원 정보를 얻어올꺼야
		
		List<ToDoList> list = new ArrayList();
		
		DBConnection dbCon = DBConnection.getInstance();
		Connection con = dbCon.dbConnect();
		
		String query = "select * from ksh.todolist";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { // row 가 있을동안 반복
			list.add(new ToDoList(
					rs.getInt("no"),
					rs.getString("todo"),
					rs.getDate("end_date"),
					rs.getString("complete")));
			
		}
		
		dbCon.dbClose(rs, pstmt, con);
		
		return list;
	}
}
