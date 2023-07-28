package ksh;

public class SortManager {
	public static Sortable getSortMethod(int menu) {
		Sortable result = null;
		
		switch (menu) {
		case 1:
			// 학번으로 정렬
			result = new AscendingByStuNo();
			break;
		case 2:
			// 이름으로 정렬
			result = new DescendingByStuname();
			break;

		default:
			// 점수로 정렬
			result = new AscendingByStuScore();
			break;
		}
		
		return result;
	}
}
