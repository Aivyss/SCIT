package java09012020;

public class Problem1 {
	public static void main(String[] args) {
		// Process
		for (int i = 1; i<=9; i++) {
			for (int j=2; j<=9; j++) {
				System.out.print(j + "*" + i + " = " + i*j + "    ");
			}
			System.out.println();
		}
	}
}
