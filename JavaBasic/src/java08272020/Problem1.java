/*
 * Assignment Operator
 * Isometric sequence 0 ~ 10
 * Result --> 55
 */
package java08272020;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int num = 0;
		int count=0;
		
		for (int i=0; i<11; i++) {
			System.out.println(num);
			count +=1;
			num += count; 
		}
	}
}
