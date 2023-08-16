package com.miniproj.dao;

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
		// TODO Auto-generated method stub
		return null;
	}

}
