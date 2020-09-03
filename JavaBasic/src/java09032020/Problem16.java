package java09032020;

public class Problem16 {
	public static void main(String[] args) {
		// Define variables
		int left, right;
		
		// Process
		for (left=1; left<=6; left++) {
			for (right=1; right<=6; right++) {
				if(left+right == 6) {
					System.out.println(left + ", " + right);
				}
			}
		}
	}
}
