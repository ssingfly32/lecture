package ksh;

import java.awt.Color;

public class Circle extends Shape {
	private int radius;

	// 부모클래스에 기본생성자가 없으면 부모를 생성할 수 없기 때문에 에러가 난다.
	// 부모클래스에 기본 생성자를 만들어 이 에러를 고칠 수 있지만 (의미가 없다)
	// 부모클래스의 Shape(Color, String, Point) 생성자를 호출하도록..
	public Circle(Color color, String name, Point p, int radius) {
		super(color, name, p);

//		부모클래스에 없는 멤버인 radius는 여기서 초기화
		this.radius = radius;
	}

	public Circle(int r, int g, int b, String name, int x, int y, int radius) {
		super(r, g, b, name, x, y);

//		부모클래스에 없는 멤버인 radius는 여기서 초기화
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		if (this instanceof Circle) {
			System.out.println("원점 : (" + this.p.getX() + ", " + this.p.getY()
			+ ") 이고, 색상 : " + this.getColor() + ", 이름 : "
			+ this.getName());
			 System.out.println(", 반지름 : " + this.radius
						+ "인 원을 그립니다!");
		}
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}
