package java09242020;

public class NameExceptionTestMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		
		try {
			p1.setName("이철수");
			p2.setName("다나카타로우");
		} catch (Exception e) {
			e.printStackTrace(); // show the line of error
			System.out.println(e.getMessage());
		}
	}
}
