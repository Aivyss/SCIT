package java10072020;

public class Student extends Person {
	// Define member variables
	private String num;
	
	public Student() {
		System.out.println("Default constructor of Student class");
	}
	
	public Student(String name, int age, String num) {
		super(name, age);
		// super.name = name;
		// super.age = age;
		this.num = num;
		System.out.println("Another constructor of Student class");
	}
}
