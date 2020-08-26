package java08252020;
/*
 * x, y are integer
 * Range of X and Y are 0 ~ 10
 */
public class LinearEquation {

	public static void main(String[] args) {
		// Define variables
		int rangeX = 10;
		int rangeY = 10;
		
		// Process
		for (int i = 0; i <= rangeX; i++) {
			for (int j = 0; j <= rangeY; j++) {
				if (2*i + 4*j == 10)
					System.out.println("x = " + i + ", y = " + j);
			}
		}
	}

}
