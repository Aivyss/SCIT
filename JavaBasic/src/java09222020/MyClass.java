package java09222020;

public class MyClass {
	// Member variables
	private int age;
	private String name;
	private boolean isMale;

	// Constructors (Method Overloading)
	public MyClass() { // Common constructor
	} 
	
	public MyClass(String name) {
		this.name = name;
	}

	public MyClass(int age) {
		this.age = age;
	}
	
	public MyClass(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public MyClass(boolean isMale) {
		this.isMale = isMale;
	}
	
	public MyClass(int age, String name, boolean isMale) {
		this.age = age;
		this.name = name;
		this.isMale = isMale;
	}
	
	
}
