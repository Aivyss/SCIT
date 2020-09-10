package java09102020;

public class Problem1 {
	public static void main(String[] args) {
		int[][] arry2D = new int[2][3];
		int forCount = 0;
		
		for (int i=0; i<arry2D.length; i++) {
			for (int j=0; j<arry2D[i].length; j++) {
				forCount++; 
				arry2D[i][j] = 10*forCount;
				System.out.print(arry2D[i][j] + "\t");
			}
			System.out.println();
		} // for end
	}
}
