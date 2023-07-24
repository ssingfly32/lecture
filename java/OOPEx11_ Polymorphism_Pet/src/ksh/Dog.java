package ksh;

public class Dog extends Pet {
	private boolean loyalty;

	public Dog(String name, int age) {
		super(name, age);
		
		this.loyalty = true;
	}

	@Override
	public void doCry() {
		System.out.println("멍멍 ^ㅅ^");
		
	}
	
	public String doSwim() {
		return "발발발";
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [loyalty=" + loyalty + "]";
	}
	
	

}
