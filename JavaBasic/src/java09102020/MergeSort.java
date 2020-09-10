package java09102020;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> arry1 = new ArrayList();
		ArrayList<Integer> arry2 = new ArrayList();
		int i = 0;

		// Input Process
		arry1 = input();
		
		// Merge Sort Process

	} // Main method end

	// Input method
	public static ArrayList<Integer> input() {
		// Define variables
		ArrayList<Integer> arry = new ArrayList();
		Scanner sc = new Scanner(System.in);
		String str = "";
		int i = 0;

		// Process
		while (true) {
			// if you input "/" then you can escape.
			if (str.equals("/")) {
				break;
			}

			arry.add(sc.nextInt());
			str = sc.next();

			i++;
		}

		return arry;
	} // Input method end
	
	// Merge Sort method
	public static ArrayList<Integer> mergeSortEven(ArrayList<Integer> arry1) {
		// Define variables
		ArrayList<Integer> arry2 = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int arraySize = arry1.size();
		
		// Divide Process
		
		
		return arry1;
	}

}
