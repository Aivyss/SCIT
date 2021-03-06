package java09022020;

import java.util.Scanner;

public class Hourglass {
	public static void main(String[] args) {
		// Define variables
		int floor;
		int count = 1;
		Scanner sc = new Scanner(System.in);

		// Input Process
		System.out.print("input odd integer : ");
		floor = sc.nextInt();

		// Arrangement
		for (int i = 1; i <= (floor / 2 + 1); i++) {
			for (int j = 1; j <= floor; j++) {
				if (count >= floor / 2 + 2) { // Reverse Process 1
					if (i == 0) { // Check the finish point
						System.exit(0);
					}
					if (j <= i - 1 || j > floor - (i - 1)) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					} 
				} else { // Forward Process
					if (j <= i - 1 || j > floor - (i - 1)) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			}
			System.out.println();
			// Reverse Check
			count++; 
			if (count >= floor / 2 + 2) {
				i = i - 2;
			}
		}
		sc.close();
	}
}
