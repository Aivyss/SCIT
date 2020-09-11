package java09112020;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertSort {
	public static void main(String[] args) {
		// Define variables
		ArrayList<Integer> input = new ArrayList();
		ArrayList<Integer> output = new ArrayList();

		// Input Process
		input = input();

		// Sort Process (Insert Sort)
		output = insertSort(input);

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

	// Insert Sort method
	public static ArrayList<Integer> insertSort(ArrayList<Integer> input) {
		int fixPoint = 1;
		int endPoint = input.size() - 1;

		// Process
		for (int i = fixPoint - 1; i >= 0; i--) { // <-- comparison
			if (input.get(i) < input.get(fixPoint)) {
				int temp = input.get(fixPoint);

				for (int j = fixPoint - 1; j >= i + 1; j--) {
					input.set(j + 1, input.get(j));
				}

				input.set(i + 1, temp);
				// Process view 1
				print(input);

				fixPoint++;
				i = fixPoint - 1;

				if (fixPoint == endPoint + 1) {
					break;
				}
			}
			if (i == 0) {
				int temp = input.get(fixPoint);

				for (int j = fixPoint - 1; j >= 0; j--) {
					input.set(j + 1, input.get(j));
				}

				input.set(0, temp);
				
				// Process view 2
				print(input);

				fixPoint++;
				i = fixPoint - 1;

				if (fixPoint == endPoint + 1) {
					break;
				}
			}
		} // for end

		return input;
	} // Insert Sort method end

	// Print Method
	public static void print(ArrayList<Integer> output) {
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i) + "\t");
		}
		System.out.println();
	}
}
