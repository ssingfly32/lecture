package ksh;

public class OOPEx8_MethodOverriding {

	private int a = 10;
	
	public static void main(String[] args) {
		OOPEx8_MethodOverriding omo = new OOPEx8_MethodOverriding();
		System.out.println(omo.toString());
	}

	@Override // @로 시작하는 문장을 annotation : 컴파일러에게 아래 메서드가 오버라이딩 되었음을 알림
	public String toString() {
		return super.toString() + "[a=" + a +"]";
	}
	
//	아래의 메서드는 오버로딩 한것임
	public String toString(String name) {
		return "OOPEx8_MethodOverriding [a=" + a + "]";
	}

}
