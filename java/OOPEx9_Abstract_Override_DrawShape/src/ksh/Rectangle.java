package ksh;

import java.awt.Color;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle(Color color, String name, Point p, int width, int height) {
		super(color, name, p);

		this.width = width;
		this.height = height;
	}

	public Rectangle(int r, int g, int b, String name, int x, int y, int width,
			int height) {
		super(r, g, b, name, x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw() {
		if (this instanceof Rectangle) {
			System.out.println("원점 : (" + this.p.getX() + ", " + this.p.getY()
			+ ") 이고, 색상 : " + this.getColor() + ", 이름 : "
			+ this.getName());
			System.out.println( ", 가로 : " + this.width + ", 세로 : "
					+ this.height + "인 사각형을 그립니다.");
		}
	}

}
