package ksh;

import java.awt.Color;

public class OOPEx9_Abstract_Override_DrawShape {

	public static void main(String[] args) {
		Circle c = new Circle(new Color(255,0,0), "빨간색원", new Point(20,10), 10);
		c.draw();
		
		Rectangle r = new Rectangle(0, 255, 0, "녹색사각형", 200, 200, 10, 20);
		r.draw();
		
		Triangle t = new Triangle(0, 0, 255, "파란 삼각형", 300, 400, 5, 20);
		t.draw();
		
		// Shape가 추상 클래스이기 때문에 객체를 생성하려면 추상메서드라 오버라이딩 되어야 한다.
		// 아래처럼 Shape의 객체를 만들더라도 실체가 분명하지 않기 때문에 어떤 일을 시킬 수 없다.
		// 위와 같은 모순이 생기기 때문에 추상클래스는 객체를 생성하기 위한 클래스 라기 보다는
		// 설계 용도로 사용되는 클래스이다.
//		Shape s = new Shape(new Color(0,0,0), "도형", new Point(1000, 1000)) {
//			
//			@Override
//			public void draw() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		System.out.println(s.toString());
		
		Painter picaso = new Painter("피카소");
		// 다형성 (polymorphism) : 객체가 여러가지 형태(type)로 변환 될 수 있는 성질
		picaso.drawing(t);
		picaso.drawing(r);
		picaso.drawing(c);
	}

}
