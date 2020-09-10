package java09102020;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortEasyBranch {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> input = new ArrayList();
		ArrayList<Integer> sorted = new ArrayList();

		// Input arrays
		input = input(); 

		// Simple merge sort
		sorted = MergeSort(divide(input));
		
		// Print
		print(sorted);

	} // Main method end
	
	// Divide ArrayList method
	public static ArrayList<Object> divide(ArrayList<Integer> input) {
		// Define variable
		ArrayList<Object> output = new ArrayList();
		ArrayList<Integer> leftSide = new ArrayList();
		ArrayList<Integer> rightSide = new ArrayList();
		int halfSize = input.size() / 2;
		
		for (int i=0; i<halfSize; i++) {
			leftSide.add(input.get(i));
		}
		
		for (int i=halfSize; i<input.size(); i++) {
			rightSide.add(input.get(i));
		}
		
		output.add(leftSide);
		output.add(rightSide);
		
		return output;
	}
	

	// Input method
	public static ArrayList<Integer> input() {
		// Define variables
		ArrayList<Integer> arry = new ArrayList();
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

	// Merge Sort method
	public static ArrayList<Integer> MergeSort(ArrayList<Object> input) {
		// Define variables
		ArrayList<Integer> arry1 = new ArrayList();
		ArrayList<Integer> arry2 = new ArrayList();
		ArrayList<Integer> output = new ArrayList();
		int i = 0;
		int j = 0;
		
		// Distribute
		arry1 = (ArrayList<Integer>) input.get(0);
		arry2 = (ArrayList<Integer>) input.get(1);

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
		}

		return output;
	}
	// Print Method
	public static void print(ArrayList<Integer> output) {
		for (int i=0; i<output.size(); i++) {
			System.out.print(output.get(i) + "\t");
		}
	}
}
