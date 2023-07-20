package ksh;

public class OOPEx4_SingleTonPattern {

	public static void main(String[] args) {
		for(int i =0; i <1000; i++) {
			SingleTon s = SingleTon.getInstance();
			System.out.println(s.hashCode());
		}
	}

}
