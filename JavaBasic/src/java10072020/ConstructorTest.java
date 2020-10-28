package java10072020;

public class ConstructorTest {

	public static void main(String[] args) {
		// Initializations
		Person prs = new Person();
		System.out.println("============================");
		// default - default
		Student std1 = new Student();
		System.out.println("============================");
		// specific - specific
		Student std2 = new Student("�씠�븳寃�", 27, "2011103149");
		
		// Test 1
		System.out.println("===========test 1=============");
		System.out.println(std1.getAge());
		System.out.println(std1.getName());
		// Test 2
		System.out.println("===========test 2=============");
		System.out.println(std2.getAge());
		System.out.println(std2.getName());
	}

}
