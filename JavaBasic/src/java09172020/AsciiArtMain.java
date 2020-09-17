package java09172020;

import java.util.Scanner;

public class AsciiArtMain {
	public static void main(String[] args) {
		// Input conditions
		Scanner sc= new Scanner(System.in);
		int[] conditions = new int[3];
		
		System.out.print("The number of Points, width, height : ");
		for (int i=0; i<conditions.length; i++) {
			conditions[i] = sc.nextInt();
		}
		
		/* 
		 * Input points informations
		 * [0~1][0~TNP-1]
		 */
		System.out.print("(x,y) point : ");
		int[][] points = new int[2][conditions[0]];
		for (int i=0; i<points[0].length; i++) {
			for (int j=0; j<points.length; j++) {
				points[j][i] = sc.nextInt();
			}
		}
		
		/* 
		 * Define cells
		 * cells [xi][yi] = [0~width-1][0~height-1] 
		 */
		double[][] cells = new double[conditions[1]][conditions[2]];
		
		// Draw
		AsciiArt aA = new AsciiArt();
		cells = aA.draw(cells, points);
		
		// Display
		aA.displayASCII(cells);
	}

}
