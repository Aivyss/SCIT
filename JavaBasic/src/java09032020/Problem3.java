package java09032020;

public class Problem3 {
	public static void main(String[] args) {
		// Define variables
		int x = 100;
		int y = 200; 
		int temp = 0;
		
		// Output1
		System.out.println("교환 전 : x=" + x + ", y="+y );
		
		// Process
		temp = x;
		x = y;
		y = temp;
		
		// Output2
		System.out.println("교환 후 : x=" + x + ", y="+y );

	}

}
