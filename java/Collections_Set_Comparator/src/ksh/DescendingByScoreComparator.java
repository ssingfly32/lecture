package ksh;

import java.util.Comparator;

public class DescendingByScoreComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// o1이 o2보다 작으면 음수, 같으면 0, o1이 o2보다 크면 양수
		// 만약 점수가 같은 학생이 있다면...학번 오름차순
		int result = 0;
		if(o1.getScore() < o2.getScore()) {
			result = 1;
		} else if(o1.getScore() > o2.getScore()){
			result = -1;
		} else { // 점수가 같다면 학번 오름차순
			// 문자열은 > , <, >=, <= 연산자를 사용하지 못한다.
			// 그러나 String 클래스가 Comparable 인터페이스를 상속받아 compareTo 메서드를
			// 구현했기 때문에 String.compareTo()를 이용하여 비교(유니코드 값)한다.
			int tmp = o1.getStuNo().compareTo(o2.getStuNo());
			if(tmp > 0){
				result = 1;
			} else  {
				result = -1;
			} 
		}
		return result;
	}

}
