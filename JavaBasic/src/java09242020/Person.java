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
	public void setName(String name) throws NameException /* 예외처리 전가 */{
		if (name.length() < 5) {
			this.name = name;
		} else {
			throw new NameException(); // 예외처리를 발생
		}
	}
}
