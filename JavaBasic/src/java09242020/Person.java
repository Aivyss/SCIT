package java09242020;

public class Person {
	// Member variables
	private String name;
	private int age;
	
	// Constructor (Method overloading)
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Name setter
	public void setName(String name) throws Exception {
		if (name.length() < 5) {
 			this.name = name;
		} else {
			throw new NameException();
		}
	}
}
