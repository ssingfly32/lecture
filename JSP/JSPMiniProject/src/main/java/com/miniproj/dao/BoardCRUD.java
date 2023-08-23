package com.miniproj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.miniproj.etc.UploadedFile;
import com.miniproj.vo.Board;

public class BoardCRUD implements BoardDAO {

	private static BoardCRUD instance = null;

	private BoardCRUD() {
	}

	public static BoardCRUD getInstance() {
		if (instance == null) {
			instance = new BoardCRUD();
		}

		return instance;
	}

	@Override
	public List<Board> selectAllBoard() throws NamingException, SQLException {
		List<Board> lst = new ArrayList<Board>();

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from board order by no desc";
		PreparedStatement pstmt = con.prepareCall(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			lst.add(new Board(rs.getInt("no"), rs.getString("writer"), rs.getString("title"),
					rs.getTimestamp("postDate"), new StringBuilder(rs.getString("content")), rs.getInt("readcount"),
					rs.getInt("likecount"), rs.getInt("ref"), rs.getInt("step"), rs.getInt("reforder"), rs.getString("isDelete")));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		return lst;
	}

	private boolean insertBoard(Board tmpBoard, Connection con) throws SQLException {
		boolean result = false;

		String query = "insert into board(writer, title, content, ref) " + "values(?, ?, ?, ?)";

		int nextRef = getNextRef(con);
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, tmpBoard.getWriter());
		pstmt.setString(2, tmpBoard.getTitle());
		pstmt.setString(3, tmpBoard.getContent().toString());
		pstmt.setInt(4, nextRef);
		tmpBoard.setNo(nextRef); // 업로드되는 파일 참조 번호를 넣기 위해

		if (pstmt.executeUpdate() == 1) {
			result = true;
		}
		pstmt.close();

		return result;
	}

	private int getNextRef(Connection con) throws SQLException {
		int nextRef = -1;

		String query = "select max(no) + 1 as nextref from board";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			nextRef = rs.getInt("nextref");
		}
		rs.close();
		pstmt.close();
		return nextRef;
	}

	@Override
	public int insertBoardWithUploadFileTransaction(Board tmpBoard, UploadedFile uf)
			throws NamingException, SQLException {
		int result = -1;

		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false);

		if (insertBoard(tmpBoard, con)) {
			uf.setBoardNo(tmpBoard.getNo()); // nextRef 값을 꺼내와 uf 객체에 넣음
			if (insertUploadFile(uf, con)) {
				if (MemberCRUD.getInstance().addPointToMember(tmpBoard.getWriter(), 2, "게시물작성", con)) {
					result = 0;
					con.commit();
				} else {
					con.rollback();
				}
			} else {
				con.rollback();
			}
		} else {
			con.rollback();
		}

		con.setAutoCommit(true);
		con.close();
		return result;
	}

	private boolean insertUploadFile(UploadedFile uf, Connection con) throws SQLException {
		boolean result = false;

		String query = "insert into uploadedfile(originalFileName, ext, newFileName, fileSize, boardNo) "
				+ "values(?, ?, ?, ?, ?)";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, uf.getOriginalFileName());
		pstmt.setString(2, uf.getExt());
		pstmt.setString(3, uf.getNewFileName());
		pstmt.setLong(4, uf.getSize());
		pstmt.setInt(5, uf.getBoardNo());

		if (pstmt.executeUpdate() == 1) {
			result = true;
		}
		pstmt.close();
		return result;
	}

	@Override
	public int insertBoardTransaction(Board tmpBoard) throws NamingException, SQLException {
		int result = -1;

		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false);

		if (insertBoard(tmpBoard, con)) {

			if (MemberCRUD.getInstance().addPointToMember(tmpBoard.getWriter(), 2, "게시물작성", con)) {
				result = 0;
				con.commit();
			} else {
				con.rollback();
			}

		} else {
			con.rollback();
		}

		con.setAutoCommit(true);
		con.close();
		return result;
	}

	@Override
	public boolean selectReadCountProcess(String userIp, int no) throws NamingException, SQLException {
		boolean result = false;

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from readcountprocess where ipAddr = ? and boardNo = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userIp);
		pstmt.setInt(2, no);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result = true;
		}

		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return result;
	}

	@Override
	public int selectHourDiff(String userIp, int no) throws NamingException, SQLException {
		int result = -1;

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "SELECT TIMESTAMPDIFF(HOUR, (select readTime from readcountprocess where "
				+ "ipAddr = ? and boardNo = ?), now()) as hourDiff";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userIp);
		pstmt.setInt(2, no);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result = rs.getInt("hourDiff");
		}

		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return result;
	}

	@Override
	public int readCountProcessWithReadCntInc(String userIp, int no, String how) throws NamingException, SQLException {
		
		int result = -1;
		
		Connection con = DBConnection.getInstance().dbConnect();
		con.setAutoCommit(false);
		
		String query = "";
		
		PreparedStatement pstmt = null;
		if(how.equals("insert")) {
			query = "INSERT INTO readcountprocess (ipAddr, boardNo) VALUES (?, ?)";
			
			pstmt = con.prepareStatement(query);
		} else if (how.equals("update")) {
			query="update readcountprocess set readTime = now() where ipAddr = ? and boardNo = ?";
		
			pstmt = con.prepareStatement(query);
		}
		pstmt.setString(1, userIp);
		pstmt.setInt(2, no);
		
		if (pstmt.executeUpdate() ==1) {
			// 조회수 증가
			if(updateReadCount(no, con)) {
				result = 0;
				con.commit();
				
			} else {
				con.rollback();
			}
		}

		con.setAutoCommit(true);
		con.close();
		return result;
	}

	private boolean updateReadCount(int no, Connection con) throws SQLException {
		boolean result = false;
		String query = "update board set readcount = readcount + 1 where no = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, no);
		
		if(pstmt.executeUpdate() == 1) {
			result = true;
		};
		pstmt.close();
		return result;
	}

	@Override
	public Board selectBoardByNo(int no) throws NamingException, SQLException {
		Board board = null;

		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from board where no = ?;";
		PreparedStatement pstmt = con.prepareCall(query);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			board = new Board(rs.getInt("no"), rs.getString("writer"), rs.getString("title"),
					rs.getTimestamp("postDate"), new StringBuilder(rs.getString("content")), rs.getInt("readcount"),
					rs.getInt("likecount"), rs.getInt("ref"), rs.getInt("step"), rs.getInt("reforder"), rs.getString("isDelete"));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		return board;
	}

	@Override
	public UploadedFile getFile(int no) throws NamingException, SQLException {
		UploadedFile uf = null;
		
		Connection con = DBConnection.getInstance().dbConnect();
		String query = "select * from uploadedfile where boardNo = ?";

		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, no);
		

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			uf = new UploadedFile(rs.getString("originalFileName"), rs.getString("ext"), "uploads/" + rs.getString("newFileName"), 
					rs.getInt("fileSize"), rs.getInt("boardNo"), rs.getString("base64String"));
		}

		DBConnection.getInstance().dbClose(rs, pstmt, con);
		return uf;
	}

	@Override
	public boolean deleteBoard(int boardNo) throws NamingException, SQLException {
		boolean result = false;
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "update board set isDelete = 'Y' where no = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, boardNo);
		
		if(pstmt.executeUpdate() == 1) {
			result = true;
		};
		
		DBConnection.getInstance().dbClose(pstmt, con);
		return result;
	}

}
