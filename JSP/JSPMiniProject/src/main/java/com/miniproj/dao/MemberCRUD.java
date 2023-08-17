package com.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.miniproj.vo.Member;

public class MemberCRUD implements MemberDAO {

	private static MemberCRUD instance = null;
	
	private MemberCRUD() {}
	
	public static MemberCRUD getInstance() {
		if(instance == null) {
			instance = new MemberCRUD();
		}
		return instance;
	}
	
	@Override
	public Member duplicateUserId(String tmpUserId) throws NamingException, SQLException {
		Member result = null;
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "select * from member where userId = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, tmpUserId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			result = new Member(rs.getString("userId"), rs.getString("userPwd"), rs.getString("userEmail"), 
					rs.getTimestamp("registerDate"), rs.getString("userImg"), rs.getInt("userPoint"));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		return result;
	}

}
