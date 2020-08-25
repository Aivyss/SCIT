
public class Not2Or3Times {
	public static void main(String[] args) {
		int rangei = 5;
		int rangef = 20;
		
		// Process
		calc(rangei, rangef);
	}
	
	// method
	public static void calc(int rangei, int rangef) {
		for (int i = rangei; i <= rangef; i++) {
			if (i%2 == 0) {}
			else if (i%3 == 0) {}
			else
				System.out.println(i);
		}
	}
}
