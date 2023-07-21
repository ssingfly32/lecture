package ksh;

class ParentA {
	private int a = 100;
	
	public int getA() {
		// 자바에서 프로그래머가 어떤 클래스를 만들면 무조건 Object로부터 상속 받게 된다.
		System.out.println(this.hashCode());
		return this.a;
	}
}

class ParentB {
	private int b = 200;
	public int getB(){
		return this.b;
	}
 }
public class OOPEx6_Inheritance_BasicConcept extends Child {

	public static void main(String[] args) {
		// [1] 우리는 이미 상속을 이용하고 있었다.
		OOPEx6_Inheritance_BasicConcept oib = new OOPEx6_Inheritance_BasicConcept();
		// oib 객체에는 hashCode()라는 멤버가 없다. 그럼에도 불구하고 oib 이름으로 자신의 멤버인양
		// hashCode() 메서드를 호출 할 수 있다. (Object에게 상속 받은 멤버)
		System.out.println(oib.hashCode()); // 모든 객체의 가장 위에는 오브젝트가 있다(hashcode() 외 다른것 대부분 다 object것이고 상속받은 것)
		
		// [2] 아래의 코드는 상속 받은 멤버를 이용한 것일까? (상속 관계 아님)
		// getA()는 ParentA의 멤버이므로 자기 자신의 멤버를 호출 (상속X)
		System.out.println(new ParentA().getA());
		
		// [3] 아래의 코드는 상속 받은 멤버를 호출 한 것이다.
		System.out.println(new Child().getA());
		
		// [4] 상속관계에서 사용되는 조건식 : instanceof (~가 ~의 객체(자식)냐?)
		ParentA pA = new ParentA();
		ParentB pB = new ParentB();
		Child c = new Child();
		
		if(pA instanceof ParentA) {
			System.out.println('네');
		}
		// c는 ParentA의 객체는 아니지만 Child가 ParentA를 상속했으므로 (equal) 관계가 성립되어
		// 아래의 코드에서는 c가 ParentA의 자식으로 나온다.
		if(c instanceof ParentA) {
			System.out.println('네');
		} else {
			System.out.println("아니오");
		}
	}
}
// 다중상속 불가!! (ParentA 와 ParentB 둘다에게 상속 받을 수 없다.)
class Child extends ParentA {
	
}
