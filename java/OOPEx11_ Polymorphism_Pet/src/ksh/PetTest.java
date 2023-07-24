package ksh;

public class PetTest {

	public static void main(String[] args) {
		Dog 몽 = new Dog("몽", 8);
		Cat 토토 = new Cat("토토", 7);
		
		// 다형성을 이용하지 않았다.
		몽.doCry();
		토토.doCry();
		
		Pet 애완동물1 = 몽; // Upcasting
		애완동물1.doCry(); // DownCasting((Dog)몽).doCry())이 내부적으로 발생
		
		Pet 애완동물2 = 토토;
		애완동물2.doCry();
		
		// doSwim()은 Pet 객체에는 없는 멤버이다. 그러므로 부모의 이름으로 호출 할 수 없다.
		// DownCasting은 Upcasting 되었던 객체가 다시 원래의 객체로 형변환 되는 것을 의미(상속관계에서 일어남)
		System.out.println(((Dog)애완동물1).doSwim());
		
		// Cat과 Dog는 상속관계가 아니므로 아래의 문법은 허용되지 않는다.
		// 몽 = (Dog)토토;
		
		
		// 부모 이름으로 모든 자식 객체를 매개변수로 받을 수 있다.
		Clinic hospital = new Clinic("구트 동물병원");
		hospital.doClinic(몽);
		hospital.doClinic(토토);
	}

}
