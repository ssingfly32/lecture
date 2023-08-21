package com.miniproj.vo;

import java.sql.Timestamp;

public class PointLog {
	private int id;
	private Timestamp when;
	private String why;
	private int howmuch;
	private String who;
	public PointLog(int id, Timestamp when, String why, int howmuch, String who) {
		super();
		this.id = id;
		this.when = when;
		this.why = why;
		this.howmuch = howmuch;
		this.who = who;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getWhen() {
		return when;
	}
	public void setWhen(Timestamp when) {
		this.when = when;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	public int getHowmuch() {
		return howmuch;
	}
	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	@Override
	public String toString() {
		return "PointLog [id=" + id + ", when=" + when + ", why=" + why + ", howmuch=" + howmuch + ", who=" + who + "]";
	}
	
	
}
