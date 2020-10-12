package java10122020.problem;

public class Main {

	public static void main(String[] args) {
		System.out.println(new ClassA(12, 6).a + new ClassB(12, 24).b + new ClassB (6, 12).c);
		System.out.println(new ClassA(12, 6).a);
		System.out.println(new ClassB(12, 24).b);
		System.out.println(new ClassB (6, 12).c);
	}

}
