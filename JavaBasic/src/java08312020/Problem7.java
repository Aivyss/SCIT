package java08312020;

public class Problem7 {

	public static void main(String[] args) {
		// Define variables
		int input = 20;
		
		//Process
		for (int i = 1; i<=input; i++) {
			if (i%2==0)
				System.out.println(i +" : 짝수");
			else
				System.out.println(i +" : 홀수");
		}
	}
}
