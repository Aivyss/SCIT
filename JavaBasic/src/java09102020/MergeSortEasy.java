package java09102020;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortEasy {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> arry1 = new ArrayList();
		ArrayList<Integer> arry2 = new ArrayList();
		ArrayList<Integer> sorted = new ArrayList();

		// Input arrays(sorted)
		arry1 = input(); // sorted
		arry2 = input(); // sorted

		// Simple merge sort
		sorted = simpleMergeSort(arry1, arry2);
		
		// Print
		print(sorted);

	} // Main method end

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

	// Simple Merge Sort method
	public static ArrayList<Integer> simpleMergeSort(ArrayList<Integer> arry1, ArrayList<Integer> arry2) {
		// Define variables
		ArrayList<Integer> output = new ArrayList();
		int i = 0;
		int j = 0;

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
