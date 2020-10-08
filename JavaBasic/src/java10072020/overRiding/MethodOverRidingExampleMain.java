package java10072020.overRiding;

public class MethodOverRidingExampleMain {

	public static void main(String[] args) {
		Person person = new Person();
		Student std = new Student("이한결", 29, "2011103149");

		System.out.println(std.printAll()); // Method overRiding from Person.printAll()
		System.out.println(std); // Method overRiding from Object.toString()
		System.out.println(person);
	}
}
