package java10072020;

public class InstanceofExample {

	public static void main(String[] args) {
		Person person = new Person();
		Student std1 = new Student("이한결", 27, "2011103149");
		
		System.out.println("=============================");
		System.out.println(person instanceof Object);
		System.out.println(person instanceof Person);
		System.out.println(person instanceof Student);
		System.out.println("=============================");
		System.out.println(std1 instanceof Student);
		System.out.println(std1 instanceof Person);
		System.out.println(std1 instanceof Object);
		System.out.println("=============================");
		
		// instanceof로 형변환 여부를 판단한 후 형변환하여 테스트
		Person stdTo = (Person) std1;
		System.out.println(stdTo.getName());
		System.out.println(stdTo.getAge());
		
	}

}
