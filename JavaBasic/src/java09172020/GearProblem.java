package java09172020;

import java.util.ArrayList;
import java.util.Scanner;

public class GearProblem {
	public static void main(String[] args) {
		// Input Process
		Scanner sc = new Scanner(System.in);
		String input1;
		String input2;
		input1 = sc.next();
		sc.nextLine();
		input2 = sc.nextLine();

		// Optimization
		String[] splited1 = spliter(input1);
		String[] splited2 = spliter(input2);

		// Measure length Process
		ArrayList<Object> container = measureLength(splited1, splited2);

		// Print
		int[][] set = (int[][]) container.get(1);
		int length = (int) container.get(0);
		for (int i = 0; i < set[0].length; i++) { // test Scan finish view
			System.out.print(set[0][i] + " ");
		}
		System.out.println();
		for (int i = 0; i < set[0].length; i++) { // test Scan finish view
			System.out.print(set[1][i] + " ");
		}
		System.out.println();
		System.out.println(length);

		sc.close();
	} // main method end

	// String spliter method
	public static String[] spliter(String input) {
		String[] splited = input.split("");

		return splited;
	}

	// Optimization
	public static ArrayList<Object> measureLength(String[] splited1, String[] splited2) {
		int fullLength = splited1.length + splited2.length;
		int[][] set = new int[2][fullLength + splited1.length];
		int[] inifi = new int[4];
		int temp = set[0].length;

		// Distribute
		for (int i = 0; i < splited1.length; i++) {
			set[0][i] = Integer.parseInt(splited1[i]);
		}
		for (int i = splited1.length; i < (fullLength + splited1.length); i++) {
			if ((i - splited1.length) > splited2.length - 1) {
				break;
			}
			set[1][i] = Integer.parseInt(splited2[i - splited1.length]);
		}

		// Check the condition
		int length = fullLength + splited1.length;
		while (true) {
			// Check starting points and end points
			inifi = startEnd(inifi, set);

			// Measure length
			boolean check = true;

			for (int j = 0; j < set[0].length; j++) {
				if (set[0][j] == 2 && set[1][j] == 2) {
					check = false;
				}
			}

			if (check) {
				//temp = (inifi[0]<=inifi[2]) ? (inifi[1]>inifi[3]) ? inifi[1] - inifi[0] + 1 : inifi[3] - inifi[0] + 1 : (inifi[1]>inifi[3]) ? inifi[1] - inifi[2] + 1 : inifi[3] - inifi[2] + 1;
											  
				if (inifi[0] <= inifi[2]) { // [0] < [2]
					if (inifi[1] > inifi[3]) {
						temp = inifi[1] - inifi[0] + 1;
					} else {
						temp = inifi[3] - inifi[0] + 1;
					}
				} else { // [0] > [2]
					if (inifi[1] > inifi[3]) {
						temp = inifi[1] - inifi[2] + 1;
					} else {
						temp = inifi[3] - inifi[2] + 1;
					}
				}

				if (temp < length) {
					length = temp;
				}
			}

			// scan breaker
			if (set[0][set[0].length - 1] != 0) {
				break;
			}

			// Movement
			for (int j = set[0].length - 1; j >= 1; j--) {
				set[0][j] = set[0][j - 1];
				if (j == 1) {
					set[0][0] = 0;
				}
			}
		} // while end

		ArrayList<Object> container = new ArrayList();
		container.add(length);
		container.add(set);

		return container;
	} // measureLength method end

	public static int[] startEnd(int[] inifi, int[][] set) {
		for (int j = 0; j < set[0].length; j++) {
			if (set[0][j] != 0) { // start
				inifi[0] = j;
				break;
			}
		}
		for (int j = set[0].length - 1; j >= 0; j--) {
			if (set[0][j] != 0) { // end
				inifi[1] = j;
				break;
			}
		}
		for (int j = 0; j < set[0].length; j++) {
			if (set[1][j] != 0) { // start
				inifi[2] = j;
				break;
			}
		}
		for (int j = set[0].length - 1; j >= 0; j--) {
			if (set[1][j] != 0) { // end
				inifi[3] = j;
				break;
			}
		}
		return inifi;
	} // startEnd method end
}
