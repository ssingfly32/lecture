package com.miniproj.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.miniproj.etc.UploadedFile;
import com.miniproj.vo.Member;
import com.miniproj.vo.PointLog;

public interface MemberDAO {
	// 유저 아이디가 중복되는지 검사하는
	Member duplicateUserId(String tmpUserId) throws NamingException, SQLException;
	
	// 업로드된 파일이 있는 경우 회원 가입
	int registerMemberWithFile(UploadedFile uf, Member newMember, String why, int howmuch) throws NamingException, SQLException;
	
	// 업로드된 파일이 없는 경우 회원 가입
	int registermember(Member newMember, String why, int howmuch) throws NamingException, SQLException;
	
	// 업로드된 파일의 정보를 uploadedFile 테이블에 insert
	int insertUploadedFileInfo(Connection con, UploadedFile uf) throws NamingException, SQLException;
	
	// 회원정보를 insert
	int insertMember(Connection con ,Member newMember) throws NamingException, SQLException;
	
	// pointlog 테이블에 회원가입 포인트 로그를 남겨야 함
	int insertPointLog(Connection con, String userId, String why, int howmuch) throws NamingException, SQLException;
	
	// 로그인
	Member loginMember(String userId, String userPwd) throws NamingException, SQLException;
	
	// member 테이블에 포인트 가감 + 로그 남기기
	int addPointToMember(String userId, int howmuch, String why) throws NamingException, SQLException;
	
	// 나의 페이지에 정보 가져오기
	Member getMemberInfo(String userId) throws NamingException, SQLException;

	// 회원의 멤버포인트 내역 가져오기
	List<PointLog> getPointLog(String userId) throws NamingException, SQLException;

	int updateEmail(String userId);
	
	
	
}
