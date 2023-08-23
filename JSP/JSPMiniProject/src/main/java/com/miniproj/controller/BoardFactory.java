package com.miniproj.controller;

import com.miniproj.service.BoardService;
import com.miniproj.service.board.DeleteBoardService;
import com.miniproj.service.board.GetBoardByNoService;
import com.miniproj.service.board.GetEntireBoardService;
import com.miniproj.service.board.WriteBoardService;

public class BoardFactory {
	private static BoardFactory instance = null;
	
	private boolean isRedirect;
	private String whereisGo;
	
	private BoardFactory () {}
	
	public static BoardFactory getInstance() {
		if (instance == null) {
			instance = new BoardFactory();
		}
		
		return instance;
	}
	
	
	
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhereisGo() {
		return whereisGo;
	}

	public void setWhereisGo(String whereisGo) {
		this.whereisGo = whereisGo;
	}

	public BoardService getService(String command) {
		BoardService service = null;
		
		if (command.equals("/board/listAll.bo")) {
			service = new GetEntireBoardService();
		} else if (command.equals("/board/writeBoard.bo")) {
			service = new WriteBoardService();
		} else if (command.equals("/board/viewBoard.bo")) {
			service = new GetBoardByNoService();
		} else if (command.equals("/board/delBoard.bo")) {
			service = new DeleteBoardService();
		}
		return service;//서블렛으로 반환
	}
}
