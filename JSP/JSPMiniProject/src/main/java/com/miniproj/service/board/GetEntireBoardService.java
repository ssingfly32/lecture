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
import com.miniproj.etc.PagingInfo;
import com.miniproj.service.BoardService;
import com.miniproj.vo.Board;

public class GetEntireBoardService implements BoardService {

	@Override
	public BoardFactory doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println("게시판 전체 목록을 가져오자!");
		int pageNo= 1;
		if(request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals("")) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		System.out.println(pageNo + "페이지 글을 출력하자");
		try {
		
		PagingInfo pi = pagingProcess(pageNo);
		System.out.println("페이징 처리 정보 : " + pi.toString());
		BoardDAO dao = BoardCRUD.getInstance();
		
			List<Board> lst = dao.selectAllBoard(pi);
			
			if(lst.size() == 0) {
				request.setAttribute("boardList", null);
				
			} else {
				request.setAttribute("boardList", lst);
				request.setAttribute("pagingInfo", pi);
			}
			
			request.getRequestDispatcher("listAll.jsp").forward(request, response);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private PagingInfo pagingProcess(int pageNo) throws NamingException, SQLException {
		PagingInfo pi = new PagingInfo();
		BoardDAO dao =  BoardCRUD.getInstance();
		// 현재 페이지	
		pi.setPageNo(pageNo);
		// 전체 게시글의 갯수
		pi.setTotalPostCnt(dao.getTotalPostCnt());
		// 총 페이지 수
		pi.setTotalPageCnt(pi.getTotalPostCnt(), pi.getViewPostCntPerPage());
		// 보여주기 시작할 글 index번호
		pi.setStartRowIndex();
		
		// ---------------------------------- 페이징 블럭 처리를 위한 코드 ---------------------------
		// 전체 페이징 블럭 갯수
		pi.setTotalPagingBlockCnt();
		// 현재 페이지가 속한 페이징 블럭 번호
		pi.setPageBlockOfCurrentPage();
		// 현재 페이징 블럭 시작 페이지 번호
		pi.setStartNumOfCurrentPagingBlock();
		// 끝 페이지 번호
		pi.setEndNumOfCurrentPagingBlock();
		
		return pi;
	}

}
