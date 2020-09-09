package java09092020;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = {20 , 25 , 30 , 10 , 15 , 5};
		int temp;
		int[] index = new int[2];
		Scanner sc = new Scanner(System.in);
		
		// Input
		for (int i=0; i<index.length; i++) {
			index[i] = sc.nextInt();
		}
		
		// Process
		temp = arry[index[0]];
		arry[index[0]] = arry[index[1]];
		arry[index[1]] = temp;
		
		// Output
		System.out.println(arry[index[0]]);
		System.out.println(arry[index[1]]);	
	}
}
