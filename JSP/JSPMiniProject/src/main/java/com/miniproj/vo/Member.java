package com.miniproj.vo;

import java.sql.Timestamp;

public class Member {
	private String userId;
	private String userPwd;
	private String userEmail;
	private Timestamp registerDate;
	private int userImg;
	private int userPoint;
	public Member(String userId, String userPwd, String userEmail, Timestamp registerDate, int userImg,
			int userPoint) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.registerDate = registerDate;
		this.userImg = userImg;
		this.userPoint = userPoint;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public int getUserImg() {
		return userImg;
	}
	public void setUserImg(int userImg) {
		this.userImg = userImg;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userEmail=" + userEmail + ", registerDate="
				+ registerDate + ", userImg=" + userImg + ", userPoint=" + userPoint + "]";
	}
	
	
}
