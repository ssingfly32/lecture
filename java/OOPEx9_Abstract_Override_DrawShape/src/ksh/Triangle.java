package ksh;

import java.awt.Color;

public class Triangle extends Shape {
	
	private int base;
	private int height;
	
	public Triangle(Color color, String name, Point p, int base, int height) {
		super(color, name, p);
		
		this.base = base;
		this.height = height;
	}
	
	public Triangle(int r, int g, int b, String name, int x, int y, int base, int height) {
		super(r, g, b, name, x, y);
		this.base = base;
		this.height = height;
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

	@Override
	public void draw() {
		if(this instanceof Triangle) {
			System.out.println("원점 : (" + this.p.getX() + ", " + this.p.getY()
			+ ") 이고, 색상 : " + this.getColor() + ", 이름 : "
			+ this.getName());
			System.out.println(", 밑변 : " + this.base + ", 높이 : "
			+ this.height + "인 사각형을 그립니다.");
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Triangle [base=" + base + ", height=" + height + "]";
	}
	
	

}
