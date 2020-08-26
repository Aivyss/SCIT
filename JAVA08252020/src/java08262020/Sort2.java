/*
 * Bubble Sort
 */
package java08262020;

import java.util.Scanner;

public class Sort2 {

	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[5];
		
		// Input Process
		arry = input(arry.length);
		
		// Sort Process
		bubbleSort(arry);
		
		// Output Process
		arryPrint(arry);
	}
	// Input Process method
	public static int[] input(int length) {
		// Define array
		int[] arry = new int[length];
		Scanner sc = new Scanner(System.in);
		
		// Input
		System.out.print("값을 순서대로 입력하시오");
		for (int i = 0; i<length; i++) {
			arry[i] = sc.nextInt();
		}
		
		// Return
		return arry;
	}
	
	// Sort Process method
	public static int[] bubbleSort(int[] arry) {
		// Define temptation value
		int temp = 0;
		
		// Sort Process
		for (int i=0; i<arry.length-1; i++) {
			for (int j=0; j<arry.length-i-1; j++) {
				if (arry[j]>=arry[j+1]) {
					temp = arry[j];
					arry[j] = arry[j+1];
					arry[j+1] = temp;
				}
			}
		}		
		return arry;
	}
	
	// Array print Process
	public static void arryPrint(int[] arry) {
		for (int i=0; i<arry.length; i++) {
			System.out.print(arry[i] + " / ");
		}
	}

}
