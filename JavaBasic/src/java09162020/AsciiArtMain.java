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
			System.out.print("points, width, height");
			conditions[i] = input();
		}
		
		double[][] cells = new double[conditions[1]][conditions[2]]; // [width-1][height-1]
		int[][] points = new int[2][conditions[0]]; // [x][y]
		
		//Input Process (Points information)
		for (int i=0; i<points[0].length; i++) {
			System.out.print("x, y points");
			points[0][i] = input();
			points[1][i] = input();
		}
		
		cells = checkPercentage(cells, points);
		
		// Exchange ASCII code
		changeASCII(cells);
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
			dx = points[0][i]-points[0][i-1]; // 5
			dy = points[1][i]-points[1][i-1]; // 5
			inclination = 1.0*dx/dy;
			for (int j=0; j<Math.abs(dx)-1; j++) { // for 2, 0~4
					if (inclination > 0) {
						if (dx>0 && dy>0) { // standard shape
							int yInitial =points[1][i-1];
							int xInitial= points[0][i-1]+j; // 0~4
							double space = 0.5*inclination*((j+1)*(j+1)-j*j);
							while (space>=1) {
								cells[xInitial][yInitial] = 1;
								space -= 1;
								yInitial +=1;
							}
							cells[xInitial][yInitial] = space;
						} else {
							int yInitial =points[1][i-1]-1;
							int xInitial= points[0][i-1]-1-j; // 0~4
							double space = 0.5*inclination*((j+1)*(j+1)-j*j);
							while (space>=1) {
								cells[xInitial][yInitial] = 1;
								space -= 1;
								yInitial -=1;
							}
							cells[xInitial][yInitial] = space;
						}
						
					} else {
						if (dx>0 && dy<0) { // standard shape
							int yInitial =points[1][i]; // lower value
							int xInitial= points[0][i]-j-1;
							double space = 0.5*inclination*(j*j-(j+1)*(j+1));
							while (space>=1) {
								cells[xInitial][yInitial] = 1;
								space -= 1;
								yInitial +=1;
							}
							cells[xInitial][yInitial] = space;
						} else {
							int yInitial =points[1][i]-1; // lower value
							int xInitial= points[0][i]+j;
							double space = 0.5*inclination*(j*j-(j+1)*(j+1));
							while (space>=1) {
								cells[xInitial][yInitial] = 1;
								space -= 1;
								yInitial -=1;
							}
							cells[xInitial][yInitial] = space;
						}
					}
				} // for 3 end
		} // for 1 end
		
		return cells;
	} // check method end
	
	public static void changeASCII(double[][] cells) {
		char[] density = new char[5];
		
		density[0] = 46;
		density[1] = 43;
		density[2] = 111;
		density[3] = 36;
		density[4] = 35;
		
		for (int j=cells[0].length-1; j>=0; j--) {
			for (int i=0; i<cells.length; i++) {
				if (cells[i][j] == 1) {
					System.out.print(density[4]);
				} else if (cells[i][j]>=0.75) {
					System.out.print(density[3]);
				} else if (cells[i][j]>=0.50) {
					System.out.print(density[2]);
				} else if (cells[i][j]>=0.25) {
					System.out.print(density[1]);
				} else {
					System.out.print(density[0]);
				}
			}
			System.out.println();
		}
	}
}
