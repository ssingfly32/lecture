package ksh;

import java.util.HashSet;
import java.util.Set;

public class KoreanTest {

	public static void main(String[] args) {
		Set<Korean> koreanSet = new HashSet<>();
		Korean k1 = new Korean("2307271231234","둘리");
		Korean k2 = new Korean("2307271231234","둘리");
		
		koreanSet.add(k1);
		koreanSet.add(k2);
		
//		koreanSet.add(new Korean("2307271231234","둘리"));
//		koreanSet.add(new Korean("2307271231234","둘리"));

		for(Korean k : koreanSet) {
			System.out.println(k.toString());
		}
		
		// ---------------------------------------------------------
		
		if(k1.equals(k2)) { // 주소값이 다르므로 다른 객체가 된다.
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		// Object로부터 상속받은 equals()를 String클래스에서 재정의(오버라이딩)
		// 하여 같은 문자열인 경우에 같은 객체가 되도록 했다.
		
		
	}

}
