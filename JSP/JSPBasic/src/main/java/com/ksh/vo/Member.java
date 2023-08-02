package com.ksh.vo;

import java.sql.Date;

public class Member {
	private String userId;
	private  String userPwd;
	private String userName;
	private String gender;
	private String military;
	private String hobbies;
	private String job;
	private Date birthDate;
	private String memo;
	
	public Member(String userId, String userPwd, String userName, String gender, String military, String hobbies,
			String job, Date birthDate, String memo) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.military = military;
		this.hobbies = hobbies;
		this.job = job;
		this.birthDate = birthDate;
		this.memo = memo;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMilitary() {
		return military;
	}

	public void setMilitary(String military) {
		this.military = military;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", gender=" + gender
				+ ", military=" + military + ", hobbies=" + hobbies + ", job=" + job + ", birthDate=" + birthDate
				+ ", memo=" + memo + "]";
	}
	
	
	
	
}
