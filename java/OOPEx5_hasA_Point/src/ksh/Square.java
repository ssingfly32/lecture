package ksh;

public class Square {
	// 사각형 : 원점, 가로, 세로 만들어보자.
	private Point p;
	private int width;
	private int length;
	
	public Square(Point p, int width, int length) {
		this.p = p;
		this.width = width;
		this.length = length;
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "Square [p=" + p + ", width=" + width + ", length=" + length
				+ "]";
	}
	
	
}
