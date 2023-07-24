package ksh;

public class Cat extends Pet {
	
	private boolean chic;

	public Cat(String name, int age) {
		super(name, age);
		this.chic = true;
	}

	@Override
	public void doCry() {
		System.out.println("야옹 -ㅅ-");
	}

	@Override
	public String toString() {
		return super.toString() + "Cat [chic=" + chic + "]";
	}
	

}
