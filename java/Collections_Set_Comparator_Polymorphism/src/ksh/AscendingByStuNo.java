package ksh;

public class AscendingByStuNo implements Sortable {

	// 학번을 오름차순으로 정렬
	@Override
	public int compare(Student o1, Student o2) {
	
		return o1.getStuNo().compareTo(o2.getStuNo());
	}

}
