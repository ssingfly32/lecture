package ksh;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		
		map.put(1, "세환");
		map.put(3, "미형");
		map.put(2, "상희");
		map.put(5, "진솔");
		map.put(1, "상진"); // 1번 키가 존재하기 때문에 새로운 value 로 오버라이드 된다
		map.put(50000, "상희");
		
		System.out.println(map.get(5));
		System.out.println(map.get(4));
		
		// map에 있는 모든 키들의 집합
		Set<Integer> keys = map.keySet();
		for(Integer i : keys) {
			System.out.println(i);
		}
		
		// map에 있는 모든 value의 집합
		Collection <String> values = map.values();
		for(String s : values) {
			System.out.println(s);
		}
		
		System.out.println("------------------------");
		
		for(Integer i : keys) {
			System.out.println(i + ":" + map.get(i));
		}
		
		System.out.println(map.containsKey(50));
	}
	
	
}
