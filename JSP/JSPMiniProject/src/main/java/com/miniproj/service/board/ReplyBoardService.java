package com.miniproj.service.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.BoardFactory;
import com.miniproj.dao.BoardCRUD;
import com.miniproj.dao.BoardDAO;
import com.miniproj.service.BoardService;
import com.miniproj.vo.Board;

public class ReplyBoardService implements BoardService {

	@Override
	public BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardFactory bf = BoardFactory.getInstance();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int step = Integer.parseInt(request.getParameter("step"));
		int reforder = Integer.parseInt(request.getParameter("reforder"));
		
		content = content.replace("\r\n", "<br />");
		
		BoardDAO dao = BoardCRUD.getInstance();
		Board tmpBoard = new Board(no, writer, title, null, new StringBuilder(content), -1, -1, ref, step, reforder, null);
		System.out.println("저장되어야 할 답글" + tmpBoard.toString());
		try {
			if(dao.insertReplyTransaction(tmpBoard)) {
				bf.setRedirect(true);
				bf.setWhereisGo("listAll.bo");
			};
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bf;
	}

}
