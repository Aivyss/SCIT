package java10072020;

public class Student2 extends Person {
	private String num;
	public Student2(String name, int age, String num) {
		// (Error due to being private variable in super class)
		//  super.name = name;
		//  super.age = age;
		this.num = num;
	}
	
}
