package java08252020;

public class Increment {

	public static void main(String[] args) {
		// Define variables
		int a = 0;
		
		
		System.out.println(++a); // print after increase
		System.out.println(a++); // increase after print
		System.out.println(a++ + ++a); // a0 + (1+1+a0) = 2 + 4 = 6
	}

}
