package ksh;

public class Circle {
	private int radius;
	private Point p;

	public Circle(int radius, Point p) {
		this.radius = radius;
		this.p = p;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {

		return "원점(" + this.p.getX() + ", " + this.p.getY() + ") 이고 ," + "반지름이"
				+ this.radius + "인 원이 그려집니다.";
//		return "Circle [radius=" + radius + ", p=" + p + "]";
	}

}
