package ksh;

public class OOPEx5_hasA_PointTest {

	public static void main(String[] args) {
		// 삼각형 : 원점, 높이, 밑변
		// 사각형 : 원점, 가로, 세로 만들어보자.
		// 원 : 원점, 반지름
		
		Point p = new Point(50, 20);
		Triangle t = new Triangle(20, 10, p);
		
		System.out.println(t.toString());
		
		Point p2 = new Point(100, 200);
		Circle c = new Circle(5, p2);
		System.out.println(c.toString());
		
		Point copyP = new Point(p);
		System.out.println(p.toString());
		System.out.println(copyP.toString());
		
		Point p3 = new Point(30, 50);
		Square s = new Square(p3, 20, 20);
		System.out.println(s);
		
	}

}
