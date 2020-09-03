/*
 * Pascal Triangle
 * 
				1					
			1		1				
		1		2		1			
 	1		3		3		1		
1		4		6		4		1	
 *
 */
package java09032020;

import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args) {
		// Define Variables
		int floor;
		Scanner sc = new Scanner(System.in);

		// Input Process
		System.out.print("input the floor of Pascal triangle : ");
		floor = sc.nextInt();
		int[][] pascal = new int[floor][2*floor-1];

		// Initialization
		pascal[0][floor-1] = 1;
		pascal[1][floor-2] = 1;
		pascal[1][floor] = 1;
		
		// Calculation
		for (int i = 2; i < floor; i++) {
			for (int j = 0; j < (2*floor-1); j++) {
				if ((floor-1+i) == j) {
					pascal[i][j] = 1;
				} else if ((floor-1-i) == j) {
					pascal[i][j] = 1;
				} else {
					if (j == 0 || j == 2*floor-2) {
					} else {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j + 1];
					}	
				}
			}
		}
		
		// Arrangement
		for (int i = 0; i < floor; i++) {
			for (int j = 0; j < (2*floor-1); j++) {
				if (pascal[i][j] == 0) {
					System.out.print("\t");
				} else {
					System.out.print(pascal[i][j] + "\t");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}
