package ksh;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
//	생성자를 이용하여 깊은 복사를 하는 코드를 작성해 보세요.
	public Point(Point origin) {
		this.x = origin.x;
		this.y = origin.y;
	}

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
