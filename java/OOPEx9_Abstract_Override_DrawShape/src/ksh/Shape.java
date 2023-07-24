package ksh;

import java.awt.Color;

// 추상 클래스 : 추상 메서드를 하나라도 멤버로 가지고 있다면 무조건 추상 클래스여야 한다.
// 또는 추상메서드를 하나도 가지고 있지 않아도 abstract 키워드를 붙이면 추상클래스가 된다.
// 추상 클래스의 사용 용도 : 클래스 설계

public abstract class Shape {
	private Color color;
	private String name;
	protected Point p;
	
	public Shape(Color color, String name, Point p) { // 객체가 생성될 때 호출, 멤버 초기화
		this.color = color;
		this.name = name;
		this.p = p;
	}
	
	public Shape(int r, int g, int b, String name, int x, int y) {
		this.color = new Color(r,g,b);
		this.name = name;
		this.p = new Point(x,y);
	}

//	getter, setter
	public Color getColor() {
		return color;
	}

	public void setColor(int r, int g, int b) {
		this.color = new Color(r,g,b);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public abstract void draw();


	@Override
	public String toString() {
		return "Shape [color=" + color + ", name=" + name + "], " + "Point[" + this.p.getX() + ", " + this.p.getY() + "]";
	}
	
	
	
	
	
}
