package java09112020;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> input = new ArrayList();
		ArrayList<Integer> output = new ArrayList();

		// Input Process
		input = input();

		// Sort Process (Bubble Sort)
		output = bubbleSort(input);
		
		// Print
		print(output);

	}// main method end

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

	// Bubble Sort method
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
		int endPoint = input.size()-1;
		
		for (int i = 0; i <= endPoint; i++) {
			for (int j = 0; j <= endPoint-i; j++) {
				if (j == endPoint-i) {
					continue;
				}
				
				if (input.get(j) > input.get(j + 1)) {
					int temp = 0;
					temp = input.get(j);
					input.set(j, input.get(j+1));
					input.set(j+1, temp);
				}
			}
		} // for end
		
		return input;
	} // Bubble Sort method end
	
	// Print Method
		public static void print(ArrayList<Integer> output) {
			for (int i=0; i<output.size(); i++) {
				System.out.print(output.get(i) + "\t");
			}
		}
}
