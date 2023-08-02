package com.ksh.vo;

public class TriangleVo {
	private int base;
	private int height;
	private int area;
	
	public TriangleVo(int base, int height) {
		super();
		this.base = base;
		this.height = height;
		this.area = (this.base * this.height)/2;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "TriangleVo [base=" + base + ", height=" + height + ", area=" + area + "]";
	}
	
	
	

}
