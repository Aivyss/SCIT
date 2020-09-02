/*
 *       1			- 1 floor -> 1 rooms
 *     2 3 4		- 2 floor -> 3 rooms
 *   5 6 7 8 9		- 3 floor -> 5 rooms
 * 10 			 	- 4 floor
 * n^2 - n floor
 */
package java09022020;

import java.util.Scanner;

public class NumberPyramid {
	public static void main(String[] args) {
		// Define variables
		int range = 0;
		int floor = 1;
		int count = 1;
		Scanner sc = new Scanner(System.in);
		
		// Input values
		range = sc.nextInt();
		
		// Floor calculation
		for (int i=1; ; i++) {
			if (range > i*i) {
				floor++;
			} else {
				break;
			}
		}
		System.out.println(floor);
		
		// Arrange Pyramid
		for (int i=1; i<=floor; i++) {
			for (int j=1; j<=(2*floor-1); j++) {
				if (j<=floor-i || j>=floor+i) {
					System.out.print("\t");
				}
				else {
					if (count>range) {
						System.exit(0);
					}
					System.out.print(count+"\t");
					count++;
				}	
			}
			System.out.println();
		}
		sc.close();
	}

}
