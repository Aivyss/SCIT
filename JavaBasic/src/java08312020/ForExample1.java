/*
 * Drawing star
 * 1 to 7
 */
package java08312020;

public class ForExample1 {
	public static void main(String[] args) {
		// Drawwing a star 1
		for (int i=0; i<7; i++) {
			for (int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("===== Divider =====");
		System.out.println();
		
		// Drawing a reverse star 2
		for (int i=0; i<7; i++) {
			for (int j=7; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
