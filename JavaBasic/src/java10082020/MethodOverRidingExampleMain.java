package java10082020;

import java10072020.overRiding.Person;
import java10072020.overRiding.Student;

public class MethodOverRidingExampleMain {

	public static void main(String[] args) {
		Person person = new Person();
		Student std = new Student("이한결", 29, "2011103149");
		Person p1 = new Student("송다솔님", 26, "광주5기");
		
		// Method overRiding from Person.printAll()
		System.out.println(std.printAll()); 
		System.out.println("=============================");
		
		// Method overRiding from Object.toString()
		System.out.println(person);
		System.out.println(std); 
		System.out.println("=============================");
		
		// Method Polymorphic Variable
		System.out.println(p1); // 가상메소드
	}
}
