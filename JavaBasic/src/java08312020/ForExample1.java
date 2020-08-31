/*
 * Drawing star
 * 1 to 7
 */
package java08312020;

public class ForExample1 {
	public static void main(String[] args) {
		System.out.println("=====  Drawing a star 1 =====");
		// Drawing a star 1
		for (int i=0; i<7; i++) {
			for (int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("===== Drawing a reverse star 2 =====");
		
		// Drawing a reverse star 2
		for (int i=0; i<7; i++) {
			for (int j=7; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("===== Drawing a star 1-2 =====");
		
		// Drawing a star 1-2
		for (int i=0; i<7; i++) {
			for (int j=7; j>-1; j--) {
				if (j<=i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("===== Drawing a star 3 =====");
		
		// Drawing a reverse star 3
		int size = 9;
		for (int i=0; i<size/2; i++) {
			for (int j=0; j<size; j++) {
				if (j<=(size/2-1 - i) || j>=(size/2+1 + i)) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
	}
}
