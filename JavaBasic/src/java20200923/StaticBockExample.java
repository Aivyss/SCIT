package java20200923;

public class StaticBockExample {
	private static int i;
	
	static { // faster than main()
		i = 100;
	}
	
	public static void main(String[] args) {
		System.out.println(i);
	}

}
