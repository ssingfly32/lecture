package ksh;

public class DescendingByStuname implements Sortable {

	// 이름 내림차순 정렬
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getStuName().compareTo(o2.getStuName()) * -1;
	}

}
