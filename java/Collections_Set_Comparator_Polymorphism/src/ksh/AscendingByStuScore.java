package ksh;

public class AscendingByStuScore implements Sortable {

	// 점수를 오름차순 정렬
	@Override
	public int compare(Student o1, Student o2) {
		int result = 0;
		if(o1.getScore() < o2.getScore()) {
			result = -1;
		} else if (o1.getScore() > o2.getScore()) {
			result = 1;
		} else if(o1.getScore() == o2.getScore()) {
			result = 1;
		}
		return result;
	}

}
