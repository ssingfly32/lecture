package com.miniproj.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.miniproj.etc.UploadedFile;
import com.miniproj.vo.Board;

public interface BoardDAO {
	
	// 게시판 전체 글 목록
	List<Board> selectAllBoard() throws NamingException, SQLException;
	
	// 게시판 글 저장(업로드가 있을 경우)
	int insertBoardWithUploadFileTransaction(Board tmpBoard, UploadedFile uf) throws NamingException, SQLException;
	
	// 게시판 글 저장 (업로드가 없을 경우)
	int insertBoardTransaction(Board tmpBoard) throws NamingException, SQLException;
	
}
