package java09102020;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortTest {

	public static void main(String[] args) {
		// Define variables
		ArrayList<Object> input = new ArrayList();
		ArrayList<Object> sorted = new ArrayList();

		// Input arrays
		input = input(); 

		// Simple merge sort
		sorted = MergeSort(divide(input));
		
		// Print
		print(sorted);

	}

	// Input method
	public static ArrayList<Object> input() {
		// Define variables
		ArrayList<Object> arry = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int i = 0;

		// Process
		while (true) {
			String str = sc.next();

			if (str.equals("/")) {
				break;
			} else {
				arry.add(Integer.parseInt(str));
				i++;
			}
		}

		return arry;
	} // Input method end

	// Divide Method
	public static ArrayList<Object> divide(ArrayList<Object> input) {
		// Define variable
		ArrayList<Object> temp = new ArrayList();
		ArrayList<Object> output = new ArrayList();
		ArrayList<Object> leftSide = new ArrayList();
		ArrayList<Object> rightSide = new ArrayList();
		int halfSize = input.size() / 2;

		if (halfSize == 0) {
			output.add(input.get(0));
		} else {
			for (int i = 0; i < halfSize; i++) { // left side
				leftSide.add(input.get(i));

			}
			temp.add(leftSide);

			for (int i = halfSize; i < input.size(); i++) { // right side
				rightSide.add(input.get(i));
			}
			temp.add(rightSide);

			divide(temp);

		}
		return output;
	} // divide method end

	// Merge Sort method
	public static ArrayList<Object> MergeSort(ArrayList<Object> input) {
		// Define variables
		ArrayList<Integer> arry1 = new ArrayList();
		ArrayList<Integer> arry2 = new ArrayList();
		ArrayList<Object> output = new ArrayList();
		ArrayList<Object> temp = new ArrayList();
		int i = 0;
		int j = 0;
		int inputSize = input.size();

		// Process
		if (inputSize == 1) {
			output = input;
			return output;
		} else {
			// Distribute
			if (inputSize == 2) {
				arry1.add((int) input.get(0));
				arry2.add((int) input.get(1));

				// Process
				while (i < arry1.size() || j < arry2.size()) {
					if (i >= arry1.size()) {
						output.add(arry2.get(j));
						j++;
					} else if (j >= arry2.size()) {
						output.add(arry1.get(i));
						i++;
					} else {
						if (arry1.get(i) < arry2.get(j)) {
							output.add(arry1.get(i));
							i++;
						} else {
							output.add(arry2.get(j));
							j++;
						}
					}
				} // while end
				
				divide(output);
			} 

		}
		return output;
	} // Merge Sort method end
	
	// Print Method
	public static void print(ArrayList<Object> output) {
		for (int i=0; i<output.size(); i++) {
			System.out.print((int)output.get(i) + "\t");
		}
	} // Print method end
}

