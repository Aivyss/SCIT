package java10072020.overRiding;

public class Person {
	// Define member variables
	protected String name;
	protected int age;
	
	// Constructors
	public Person() {
		System.out.println("Default constructor of Person class");
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Another constructor of Person class");
	}
	
	public String printAll() { // Method overRiding target
		return "name : " + this.name + ", Age : " + this.age;
	}
	
	// Setter and Getter
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
