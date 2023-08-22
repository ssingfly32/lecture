package com.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.miniproj.etc.UploadedFile;
import com.miniproj.vo.Member;
import com.miniproj.vo.PointLog;

public class MemberCRUD implements MemberDAO {
	private static MemberCRUD instance = null;

	private MemberCRUD() {
	}

	public static MemberCRUD getInstance() {
		if (instance == null) {
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
		while (rs.next()) {
			result = new Member(rs.getString("userId"), rs.getString("userPwd"), rs.getString("userEmail"),
					rs.getTimestamp("registerDate"), rs.getInt("userImg"), rs.getInt("userPoint"));

		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return result;
	}

	@Override
	public int registerMemberWithFile(UploadedFile uf, Member newMember, String why, int howmuch)
			throws NamingException, SQLException {
		int result = -1;
		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false); // 트랜잭션 처리를 시작하겠다.
		// (1) 업로드된 파일의 정보를 uploadedFile 테이블에 insert
		int no = insertUploadedFileInfo(con, uf);
		int insertCnt = -1;
		// (2) 회원가입(회원 정보 + (1)번에서 저장된 no)
		if (no != -1) {
			newMember.setUserImg(no);
			insertCnt = insertMember(con, newMember);
		}
		int logCnt = -1;
		// (3) pointLog 테이블에 회원가입 포인트 로그 insert
		if (insertCnt == 1) {
			logCnt = insertPointLog(con, newMember.getUserId(), why, howmuch);
		}

		if (logCnt == 1) {
			con.commit();
			result = 0;
		} else {
			con.rollback();
		}
		con.setAutoCommit(true); // 트랜잭션 처리 끝
		con.close();

		return result;
	}

	@Override
	public int insertUploadedFileInfo(Connection con, UploadedFile uf) throws NamingException, SQLException {
		int result = -1;
		String query = "insert into uploadedfile(originalFileName, ext, newFileName, fileSize) values(?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, uf.getOriginalFileName());
		pstmt.setString(2, uf.getExt());
		pstmt.setString(3, uf.getNewFileName());
		pstmt.setLong(4, uf.getSize());

		pstmt.executeUpdate();
		pstmt.close();

		result = getUploadedFileNo(con, uf);

		return result; // 현재 업로드된 파일의 저장 번호
	}

	private int getUploadedFileNo(Connection con, UploadedFile uf) throws NamingException, SQLException {
		int result = -1;
		String query = "select no from uploadedfile where newFileName = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, uf.getNewFileName());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			result = rs.getInt("no");
		}

		rs.close();
		pstmt.close();

		return result;
	}

	@Override
	public int insertMember(Connection con, Member newMember) throws NamingException, SQLException {
		int result = -1;
		String query = "insert into member(userId, userPwd, userEmail, userImg) values(?, sha1(md5(?)), ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, newMember.getUserId());
		pstmt.setString(2, newMember.getUserPwd());
		pstmt.setString(3, newMember.getUserEmail());
		pstmt.setInt(4, newMember.getUserImg());

		result = pstmt.executeUpdate();
		pstmt.close();

		return result; // 가입된 회원의 명 수(1명)
	}

	@Override
	public int insertPointLog(Connection con, String userId, String why, int howmuch)
			throws NamingException, SQLException {
		int result = -1;

		String query = "insert into pointlog(why, howmuch, who) values(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, why);
		pstmt.setInt(2, howmuch);
		pstmt.setString(3, userId);
		result = pstmt.executeUpdate();
		pstmt.close();

		return result;
	}

	@Override
	public int registermember(Member newMember, String why, int howmuch) throws NamingException, SQLException {
		int result = -1;
		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false);

		// 1) 회원가입
		int insertCnt = insertMember(con, newMember, false);
		int logCnt = -1;
		// 2) 포인트 로그에 회원가입 포인트 로그 남기기
		if (insertCnt == 1) {
			logCnt = insertPointLog(con, newMember.getUserId(), why, howmuch);
		}
		if (logCnt == 1) {
			con.commit();
			result = 0;
		} else {
			con.rollback();
		}
		con.setAutoCommit(true);
		con.close();

		return result;
	}

	private int insertMember(Connection con, Member newMember, boolean b) throws SQLException {
		int result = -1;
		String query = "insert into member(userId, userPwd, userEmail) values(?, sha1(md5(?)), ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, newMember.getUserId());
		pstmt.setString(2, newMember.getUserPwd());
		pstmt.setString(3, newMember.getUserEmail());

		result = pstmt.executeUpdate();
		pstmt.close();

		return result; // 가입된 회원의 명 수(1명)
	}

	@Override
	public Member loginMember(String userId, String userPwd) throws NamingException, SQLException {
		Member loginMember = null;

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from member m inner join uploadedfile u on m.userImg = u.no where userId = ? and userPwd = sha1(md5(?));";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPwd);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			loginMember = new Member(rs.getString("userId"), rs.getString("userPwd"), rs.getString("userEmail"),
					rs.getTimestamp("registerDate"), rs.getInt("userImg"), rs.getInt("userPoint"),
					rs.getString("newFileName"), rs.getString("isAdmin"));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return loginMember;
	}

	public boolean addPointToMember(String userId, int howmuch, String why, Connection con)
			throws NamingException, SQLException {
		boolean resultBool = false;

		String query = "update member set userPoint = userPoint + ? where userId = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, howmuch);
		pstmt.setString(2, userId);

		int result = pstmt.executeUpdate();

		pstmt.close();
		if (result == 1) {
			int afterPointLog = insertPointLog(con, userId, why, howmuch);

			if (afterPointLog == 1) {
				resultBool = true;
			} 
		}

		return resultBool;
	}

	@Override
	public int addPointToMember(String userId, int howmuch, String why) throws NamingException, SQLException {
		int result = -1;

		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false);
		String query = "update member set userPoint = userPoint + ? where userId = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, howmuch);
		pstmt.setString(2, userId);

		result = pstmt.executeUpdate();

		pstmt.close();
		if (result == 1) {
			int afterPointLog = insertPointLog(con, userId, why, howmuch);

			if (afterPointLog == 1) {
				con.commit();
				result = 0;
			} else {
				con.rollback();
			}
		}

		con.setAutoCommit(true);
		con.close();

		return result;

	}

	@Override
	public Member getMemberInfo(String userId) throws NamingException, SQLException {
		Member memberInfo = null;

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select m.*, u.newFileName from member m inner join uploadedfile u "
				+ "on m.userImg = u.no where userId = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userId);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			memberInfo = new Member(rs.getString("userId"), rs.getString("userPwd"), rs.getString("userEmail"),
					rs.getTimestamp("registerDate"), rs.getInt("userImg"), rs.getInt("userPoint"),
					rs.getString("newFileName"), rs.getString("isAdmin"));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return memberInfo;
	}

	@Override
	public List<PointLog> getPointLog(String userId) throws NamingException, SQLException {
		List<PointLog> pl = new ArrayList<PointLog>();
		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from pointlog where who = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userId);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pl.add(new PointLog(rs.getInt("id"), rs.getTimestamp("when"), rs.getString("why"), rs.getInt("howmuch"),
					rs.getString("who")));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return pl;
	}

	@Override
	public int updateEmail(String userId, String userEmail) throws NamingException, SQLException {
		Connection con = DBConnection.getInstance().dbConnect();
		String query = "update member set userEmail = ? where userId = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userEmail);
		pstmt.setString(2, userId);
		
		int result = pstmt.executeUpdate();
		DBConnection.getInstance().dbClose(pstmt, con);
		return result;
	}
	
	

}