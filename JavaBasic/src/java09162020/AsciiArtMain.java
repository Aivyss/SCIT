package java09162020;

import java.util.Scanner;

public class AsciiArtMain {
	public static void main(String[] args) { 
		/*
		 * Conditions settings
		 * conditions[0] : The number of points
		 * conditions[1] : width
		 * conditions[2] : height
		 */
		int[] conditions = new int[3];
		
		for (int i=0; i<conditions.length; i++) {
			conditions[i] = input();
		}
		
		double[][] cells = new double[2][conditions[2]]; // [x,y][index]
		int[][] points = new int[conditions[0]][conditions[0]]; // [x][y]
		
		//Input Process (Points information)
		for (int i=0; i<conditions.length; i++) {
			points[0][i] = input();
			points[1][i] = input();
		}
		
		// Process
		
	} // main method end
	
	public static int input() {
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();
		
		return input;
	} // input method end
	
	public static double[][] checkPercentage(double[][] cells, int[][] points){
		int dx;
		int dy;
		double inclination;
		
		for (int i=1; i<points.length; i++) { // for 1
			dx = points[0][i]-points[0][i-1];
			dy = points[1][i]-points[1][i-1];
			inclination = 1.0*dx/dy;
			
			for (int j=0; j<dx; j++) { // for 2
					if (inclination > 0) {
						if (dx>0 || dy>0) { // standard shape
							double temp = 0.5*(inclination*(j+1)*(j+1)-inclination*j*j);
							int ydcre =points[1][i];
							while (temp>=1) {
								cells[ydcre][points[0][i-1]+j] = 1;
								ydcre -= 1;
								temp -= 1;
							}
							cells[ydcre][points[0][i-1]+j] = temp;
						} else {
							
						}
						
					} else {
						if (dx>0 || dy<0) { // standard shape
							
						} else {
							
						}
					}
				} // for 3 end
		} // for 1 end
		
		return cells;
	} // check method end
}
