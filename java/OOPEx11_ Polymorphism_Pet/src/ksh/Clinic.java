package ksh;

public class Clinic {
	private String name;
	
	public Clinic(String name) {
		this.name = name;
	}
	
	public void doClinic(Pet p) {
		System.out.println(p.toString() + "을 치료합니다");
	}
}
