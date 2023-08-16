package com.miniproj.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.miniproj.vo.Member;

public interface MemberDAO {
	// 유저 아이디가 중복되는지 검사하는
	Member duplicateUserId(String tmpUserId) throws NamingException, SQLException;
}
