package ksh;

public class Triangle {
	private int base;
	private int height;
	private Point p;

	public Triangle(int base, int height, Point p) {
		this.base = base;
		this.height = height;
		this.p = p;
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

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {

		return "원점(" + p.getX() + ", " + p.getY() + ") 이고, 밑변이" + this.base
				+ "이고, 높이가 " + this.height + "인 삼각형이 그려집니다";
//		return "Triangle [base=" + base + ", height=" + height + ", p=" + p
//				+ "]";
	}

}
