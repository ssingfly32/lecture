package ksh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	// Set : 순서를 유지하지 않고 중복을 허용하지 않는 데이터를 관리한다.
	// HashSet : 정렬되지 않은 데이터를 관리하고, TreeSet은 데이터를 정렬하여 관리한다.
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(10); set.add(30); set.add(10);
		set.add(20); set.add(50);  
		
		for(Integer i : set) {
			System.out.println(i);
		}
		
		System.out.println("-------------------------");
		Set<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(new Integer(10)); treeSet.add(30); treeSet.add(10);
		treeSet.add(20); treeSet.add(50); 
		
//		for(Integer i : treeSet) {
//			System.out.println(i);
//		}
		
		List<Integer> list = new ArrayList<>();//앞이 제너릭이면 뒤에 생략가능
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		
		treeSet.addAll(list);
		
		for(Integer i : treeSet) {
			System.out.println(i);
		}
		
		Set<String> stringSet = new TreeSet<>();
		stringSet.add("영민");
		stringSet.add("민정");
		stringSet.add("지영");
		
		for(String i : stringSet) {
			System.out.println(i);
		}

	}

}
