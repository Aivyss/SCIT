package java09092020;

public class MinMax {
	public static void main(String[] args) {
		// Define varaibles
		int[] arry = {5,3,6,7,2,4,8};
		int min = 0;
		int max = 0;
		
		// Process
		for (int i=0; i<arry.length; i++) {
			if (i == 0) {
				min = arry[i];
			}
			if (arry[i] > max) {
				max = arry[i];
			}
			if (arry[i]<min) {
				min = arry[i];
			}
		}
		
		// Output
		System.out.println(min);
		System.out.println(max);
	}
}
