package com.miniproj.vo;

import java.sql.Timestamp;

public class ReadCountProcess {
	private int no;
	private String ipAddr;
	private int boardNo;
	private Timestamp readTime;
	
	public ReadCountProcess(int no, String ipAddr, int boardNo, Timestamp readTime) {
		super();
		this.no = no;
		this.ipAddr = ipAddr;
		this.boardNo = boardNo;
		this.readTime = readTime;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public Timestamp getReadTime() {
		return readTime;
	}
	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}
	@Override
	public String toString() {
		return "ReadCountProcess [no=" + no + ", ipAddr=" + ipAddr + ", boardNo=" + boardNo + ", readTime=" + readTime
				+ "]";
	}
	
	
	
}
