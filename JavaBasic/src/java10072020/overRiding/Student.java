package java10072020.overRiding;

public class Student extends Person {
	// Define member variables
	private String num;
	
	public Student() {
		System.out.println("Default constructor of Student class");
	}
	
	public Student(String name, int age, String num) {
		super(name, age);
		this.num = num;
		System.out.println("Another constructor of Student class");
	}
	
	public String printAll() { // Method overRiding target
		return "name : " + super.name + ", Age : " + super.age + ", num :" + this.num;
	}
	
	public String toString() { // Obeject method -> stuent method
		return "name : " + super.name + ", Age : " + super.age + ", num :" + this.num;
	}
}
