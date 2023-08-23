package com.miniproj.vo;

import java.sql.Timestamp;

public class Board {
	private int no;
	private String writer;
	private String title;
	private Timestamp postDate;
	private StringBuilder content;
	private int readcount;
	private int likecount;
	private int ref;
	private int step;
	private int reforder;
	private String isDelete;
	
	public Board(int no, String writer, String title, Timestamp postDate, StringBuilder content, int readcount,
			int likecount, int ref, int step, int reforder, String isDelete) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
		this.readcount = readcount;
		this.likecount = likecount;
		this.ref = ref;
		this.step = step;
		this.reforder = reforder;
		this.isDelete = isDelete;
	}
	
	
	public String getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getPostDate() {
		return postDate;
	}
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	public StringBuilder getContent() {
		return content;
	}
	public void setContent(StringBuilder content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getReforder() {
		return reforder;
	}
	public void setReforder(int reforder) {
		this.reforder = reforder;
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", writer=" + writer + ", title=" + title + ", postDate=" + postDate + ", content="
				+ content + ", readcount=" + readcount + ", likecount=" + likecount + ", ref=" + ref + ", step=" + step
				+ ", reforder=" + reforder + ", isDelete=" + isDelete + "]";
	}
	
	
	
}
