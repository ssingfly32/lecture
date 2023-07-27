package ksh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ArrayListTest {

	// 순서가 있고, 중복된 데이터가 저장되는 구조
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>(); // 다형성 이용
		arr.add("상희");
		arr.add("진솔");
		arr.add("재용");
		arr.add("용진");
		arr.add("상희");
		arr.add("진솔");
//		for (int i = 0; i< arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}

		// 이터레이터 줄세우기.. 아래를 실행하면 위 for문과 똑같
		Iterator<String> iter = arr.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(5);

		ArrayList<Double> arr1 = new ArrayList<Double>();
		arr1.add(3.14d);
		arr1.add(4.0001);
		arr1.add(3d);

		// 추상 클래스 Number는 기본 유형인 바이트, 더블, 플로트, 인트, 롱, 숏으로 
		// 변환할 수 있는 숫자 값을 나타내는 플랫폼 클래스의 슈퍼클래스입니다.
		List<Number> arr2 = new ArrayList<Number>();
		arr2.addAll(stack);
		arr2.addAll(arr1);

	}

}
