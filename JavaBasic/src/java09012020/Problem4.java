package java09012020;

public class Problem4 {
	public static void main(String[] args) {
		for (int i=2; i<=9; i++) {
			if (i%2==0) {
				for (int j=1; j<=5; j++) {
					System.out.println(i + "*" + j + " = " + i*j);
				}
			} else
				for (int j=6; j<=9; j++) {
					System.out.println(i + "*" + j + " = " + i*j);
				}
		}
	}
}
