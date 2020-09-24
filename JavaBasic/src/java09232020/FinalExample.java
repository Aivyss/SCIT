package java20200923;

public class FinalExample {
	// Define member variables ( fixed by final )
	final int i = 9;
	public static final double PI = 3.141592;
	
	public void go() {
		// Can't change value
		// i = 10; ----> error
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		// Define instance
		FinalExample fi = new FinalExample();
		fi.go();
	}
}
