package java09022020;
import java.util.Scanner;

public class DivisorProblem {
	public static void main(String[] args) {
		// Define values
		int searchNumber=0;
		
		// Input Process
		searchNumber = input();
		
		// Divisor array
		int[] arry = div(searchNumber);
		
		// Output
		printarry(arry);
		
	}
	
	// Input method (integer type)
	public static int input() {
		int input;
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력값(정수타입)을 정하시오 : ");
		input = scanner.nextInt();
		scanner.close();
		
		return input;
	}
	
	// Divisor method
	public static int[] div(int input) {
		// Define array
		int[] arry = new int[input];
		int count = 0;
		// Process
		for (int i=1; i<=input; i++) {
			if (input%i == 0) {
				arry[i-1] = i;
				count++;
			} 
		}
		//Define array2
		int[] arry2 = new int[count];
		int j = 0;
		// Select
		for (int i=0; i<input; i++) {
			if (arry[i] != 0) {
				arry2[j] = arry[i];
				j++;
			}
		}
		return arry2; 
	}
	
	// Array print method
	public static void printarry(int[] arry) {
		for (int i=0; i<arry.length; i++) {
			System.out.print(arry[i] + "\t");
		}
	}
}
