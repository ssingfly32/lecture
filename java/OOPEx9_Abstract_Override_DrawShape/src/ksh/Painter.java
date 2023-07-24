package ksh;

public class Painter {
	private String name;
	
	public Painter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Shape s = t; (묵시적 형변환 => 업캐스팅(upCasting))
	// Shape s = r; (묵시적 형변환 => 업캐스팅(upCasting))
	// Shape s = c; (묵시적 형변환 => 업캐스팅(upCasting))
	
	// 다형성의 특징 (1): 부모 객체(Shape) 이름으로 모든 자식객체(T, R, C)를 매개변수로 받을 수 있다.
	
	public void drawing(Shape s) { 
//		System.out.println(s.toString());
		
		// draw()가 오버라이딩 되었기 때문에 부모(Shape)가 가지고 있는 draw가 호출되는 것이 아니라
		// 자식이 오버라이딩 한 멤버가 먼저 호출(동적 로딩)
		
		// 다형성 특징 (2) : 부모(Shape)타입은 draw()가 추상메서드이다.
		// 하지만, 자식이 구현해 놓은 멤버를 사용 가능하게 되었다.
		// 부모 이름으로 자식 멤버를 사용 가능하다.
		
		// s가 Rectangle 이라면 -> ((Rectangle)s).draw(); 다운캐스팅 되어서 실행
		// s가 Triangle 이라면 -> ((Triangle)s).draw(); 다운캐스팅 되어서 실행
		// s가 Circle 이라면 -> ((Circle)s).draw(); 다운캐스팅 되어서 실행

		s.draw(); 
	}
}
