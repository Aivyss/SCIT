package java09082020;

import java.util.Random;
import java.util.Scanner;

public class LifeGame {
	public static void main(String[] args) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int scale;

		// Input Process (Array size)
		System.out.print("Input cell size (n x n) : ");
		scale = sc.nextInt();

		// Define Array cells and initialization
		int[][] cells = new int[scale][scale];
		 
		/* Methuselah example
		scale = 30; 
		cells [5+10][5+10] = 1;
		cells [5+10][4+10] = 1;
		cells [4+10][6+10] = 1;
		cells [4+10][5+10] = 1;
		cells [6+10][5+10] = 1;
		*/
		
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < scale; j++) {
				cells[i][j] = rd.nextInt(2);
			}
		}
		
		// Initial Output
		print(cells, scale);

		// Time evolution
		int i = 0;
		while (i < 1500) {
			clearScreen();
			cells = lifeGameEvolution(cells, scale);
			print(cells, scale);
			// 조건 멈춤
			if (check(cells, scale) == false) {
				break;
			}
			
			try { // Time evolutions
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			i++;
		}
	} // main method end

	// Life Game method
	public static int[][] lifeGameEvolution(int[][] cells, int scale) {
		// Define variables
		int sum = 0;
		int endPoint = cells[0].length - 1;
		int[][] evolv = new int[scale][scale];
		Random rd = new Random();

		// Evolution
		for (int i = 0; i < cells[0].length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (i == 0) {
					if (j == 0) {
						sum = (cells[0][1] + cells[1][0] + cells[1][1]);
					} else if (j == endPoint) {
						sum = (cells[0][endPoint - 1] + cells[1][endPoint] + cells[1][endPoint - 1]);
					} else {
						sum = (cells[0][j - 1] + cells[0][j + 1] + cells[1][j - 1] + cells[1][j] + cells[1][j + 1]);
					}
				} else if (i == endPoint) {
					if (j == 0) {
						sum = (cells[endPoint][1] + cells[endPoint - 1][0] + cells[endPoint - 1][1]);
					} else if (j == endPoint) {
						sum = (cells[endPoint][endPoint - 1] + cells[endPoint - 1][endPoint]
								+ cells[endPoint - 1][endPoint - 1]);
					} else {
						sum = (cells[endPoint][j - 1] + cells[endPoint][j + 1] + cells[endPoint - 1][j - 1]
								+ cells[endPoint - 1][j] + cells[endPoint - 1][j + 1]);
					}
				} else if (j == 0 || j == endPoint) {
					if (j == 0) {
						sum = (cells[i - 1][0] + cells[i + 1][0]);
						sum += (cells[i - 1][1] + cells[i][1] + cells[i + 1][1]);
					} else {
						sum = (cells[i - 1][endPoint] + cells[i + 1][endPoint]);
						sum += (cells[i - 1][endPoint - 1] + cells[i][endPoint - 1] + cells[i + 1][endPoint - 1]);
					}
				} else {
					for (int k = i - 1; k <= i + 1; k++) {
						for (int l = j - 1; l <= j + 1; l++) {
							if (k == i && l == j) {
							} else {
								sum += cells[k][l];
							}
						}
					}
				}

				// Check the status (revival, kill, continue)
				if (sum <= 1 || sum >= 4) {
					evolv[i][j] = 0;
				} else if (sum == 2) {
					evolv[i][j] = cells[i][j];
				} else if (sum == 3) {
					evolv[i][j] = 1;
				}
				sum = 0;
			} // in for end
		} // out for end
		return evolv;
	} // LifeGameEvolution method end

	// Input method
	public static int[][] inputRd(int[][] cells, int scale) {
		Random rd = new Random();
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < scale; j++) {
				cells[i][j] = rd.nextInt(2);
			}
		}
		return cells;
	}

	// Check the condition method
	public static boolean check(int[][] cells, int scale) {
		int count = 0;
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < scale; j++) {
				//System.out.print(cells[i][j]);
				if (cells[i][j] == 1) {
					count++;
				}
			}
			//System.out.println();
		}

		return count > 0;
	}

	// Output method
	public static void print(int[][] cells, int scale) {
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < scale; j++) {
				if (cells[i][j] == 1) {
					System.out.print("■");
				} else {
					System.out.print("□");
				}
			}
			System.out.println();
		}
	}

	// Screen method
	public static void clearScreen() {
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}
}
