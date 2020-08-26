package java08252020;

public class Detect100 {

	public static void main(String[] args) {
		// Define variables
		int count = 0;
		int absV = 1;
		int sum = 0;
		
		// Process
		while (sum < 100) {
			if ((count+1)%2 == 0) {
				sum += absV;
				absV++;
				count++;
			} else {
				sum += absV*(-1);
				absV++;
				count++;
			}
		}
		
		// Output
		System.out.println("Count = " + count);
	}

}
