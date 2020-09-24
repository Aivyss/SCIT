package java09242020;

public class ErrorTest {

	public static void main(String[] args) {
		// Define variables
		int num1 = 3;
		int num2 = 0;
		
		// Process
		System.out.println("Start");
		
		try {
			System.out.println(num1/num2);
		} catch(ArithmeticException e) {
			System.out.println("Error: divide 0");
		} finally {
			System.out.println("finally bracket");
		}
		System.out.println("End");
	}

}
