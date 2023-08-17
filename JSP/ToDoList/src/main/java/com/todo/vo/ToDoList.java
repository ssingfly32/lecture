package com.todo.vo;

import java.sql.Date;

public class ToDoList {
	private int no;
	private String todo;
	private Date end_date;
	private String complete;
	
	public ToDoList(int no, String todo, Date end_date, String complete) {
		super();
		this.no = no;
		this.todo = todo;
		this.end_date = end_date;
		this.complete = complete;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "ToDoList [no=" + no + ", todo=" + todo + ", end_date=" + end_date + ", complete=" + complete + "]";
	}
	
	
}
