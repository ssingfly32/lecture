package com.miniproj.service.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproj.controller.BoardFactory;
import com.miniproj.dao.BoardCRUD;
import com.miniproj.dao.BoardDAO;
import com.miniproj.service.BoardService;
import com.miniproj.vo.Board;

public class GetEntireBoardService implements BoardService {

	@Override
	public BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("게시판 전체 목록을 가져오자!");
		
		BoardDAO dao = BoardCRUD.getInstance();
		try {
			List<Board> lst = dao.selectAllBoard();
			if(lst.size() == 0) {
				request.setAttribute("boardList", null);
				System.out.println("chk1");
			} else {
				request.setAttribute("boardList", lst);
			}
			
			request.getRequestDispatcher("listAll.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
