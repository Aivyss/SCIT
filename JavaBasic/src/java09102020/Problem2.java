package java09102020;

import java.util.Random;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int[] arr = {10,20,30,40,50};
		Random rd = new Random();
		
		// Output
		System.out.println(arr[rd.nextInt(arr.length)]);
	}
}
