package ksh;

import java.awt.Color;

// 추상 클래스 : 추상 메서드를 하나라도 멤버로 가지고 있다면 무조건 추상 클래스여야 한다.
// 또는 추상메서드를 하나도 가지고 있지 않아도 abstract 키워드를 붙이면 추상클래스가 된다.
// 추상 클래스의 사용 용도 : 클래스 설계

public abstract class Shape {
	private Color color;
	private String name;
	private Point p;
	
	public Shape(Color color, String name, Point p) {
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
	
//	추상 메서드 : body가 없는 메서드
//	지금은 어떤 도형을 그릴지 모르기 때문에 쓸 코드가 없음.
	public abstract void draw(Shape s);

	@Override
	public String toString() {
		return "Shape [color=" + color + ", name=" + name + "]";
	}
	
	
	
	
	
}
