package java09172020;

public class AsciiArt {
	
	public AsciiArt() { // Constructor

	}

	public double[][] draw(double[][] cells, int[][] points) {
		/*
		 * Define sums array [0~points.length-1][0~width-1][0~height-1]
		 */
		double[][][] sums = new double[points[0].length][cells.length][cells[0].length];

		// Define inclination, dx, dy
		// range 0:1, 1:2, ......., TNP-2:TNP-1
		int[] dx = new int[points[0].length];
		int[] dy = new int[points[0].length];
		double[] inclination = new double[points[0].length];

		for (int i = 1; i < dx.length; i++) {
			dx[i - 1] = points[0][i] - points[0][i - 1];
			dy[i - 1] = points[1][i] - points[1][i - 1];
			inclination[i - 1] = 1.0 * dy[i - 1] / dx[i - 1];
		}

		// Put values
		for (int i = 1; i < dx.length; i++) {
			for (int j = 0; j < Math.abs(dx[i - 1]); j++) { // for 2 end
				if (inclination[i - 1] > 0) {
					if (dx[i - 1] > 0) {
						// Generate Triangle
						int xInitial = points[0][i - 1] + j;
						int yInitial = points[1][i - 1];
						double space = 0.5 * inclination[i - 1] * ((j + 1) * (j + 1) - j * j);
						while (space > 1) {
							sums[i - 1][xInitial][yInitial] = 1.0;
							yInitial += 1;
							space -= 1;
						}
						sums[i - 1][xInitial][yInitial] = space;

						// Generate orthogonal
						yInitial = points[1][i - 1];
						while (yInitial > 0) {
							yInitial -= 1;
							sums[i - 1][xInitial][yInitial] = 1.0;
						}
					} else { // dx[i-1] < 0
						// Generate Triangle
						int xInitial = points[0][i] + j;
						int yInitial = points[1][i];
						double space = 0.5 * inclination[i - 1] * ((j + 1) * (j + 1) - j * j);
						while (space > 1) {
							sums[i - 1][xInitial][yInitial] = -1.0;
							yInitial += 1;
							space -= 1;
						}
						sums[i - 1][xInitial][yInitial] = -space;

						// Generate orthogonal
						yInitial = points[1][i];
						while (yInitial > 0) {
							yInitial -= 1;
							sums[i - 1][xInitial][yInitial] = -1.0;
						}
					}
				} else { // inclination < 0
					if (dx[i - 1] > 0) {
						// Generate Triangle
						int xInitial = points[0][i] - j - 1;
						int yInitial = points[1][i];
						double space = 0.5 * inclination[i - 1] * (j * j - (j + 1) * (j + 1));
						while (space > 1) {
							sums[i - 1][xInitial][yInitial] = 1.0;
							yInitial += 1;
							space -= 1;
						}
						sums[i - 1][xInitial][yInitial] = space;

						// Generate orthogonal
						yInitial = points[1][i];
						while (yInitial > 0) {
							yInitial -= 1;
							sums[i - 1][xInitial][yInitial] = 1.0;
						}
					} else { // dx[i-1] < 0
						// Generate Triangle
						int xInitial = points[0][i - 1] - j - 1;
						int yInitial = points[1][i - 1];
						double space = 0.5 * inclination[i - 1] * (j * j - (j + 1) * (j + 1));
						while (space > 1) {
							sums[i - 1][xInitial][yInitial] = -1.0;
							yInitial += 1;
							space -= 1;
						}
						sums[i - 1][xInitial][yInitial] = -space;

						// Generate orthogonal
						yInitial = points[1][i - 1];
						while (yInitial > 0) {
							yInitial -= 1;
							sums[i - 1][xInitial][yInitial] = -1.0;
						}
					}
				}
			} // for 2 end
		}

		// end point - start point
		// TNP-1:0
		dx[dx.length - 1] = points[0][0] - points[0][points[0].length - 1];
		dy[dy.length - 1] = points[1][0] - points[1][points[0].length - 1];
		inclination[dx.length - 1] = 1.0 * dy[dy.length - 1] / dx[dx.length - 1];
		
		for (int j = 0; j < Math.abs(dx[dx.length-1]); j++) {
			if (dy[dy.length-1]>0) { // dx>0, dy>0
				// Generate triangle
				int xInitial = points[0][points[0].length-1]+j;
				int yInitial = points[1][points[0].length-1];
				double space = 0.5 * inclination[dx.length - 1] * (j * j - (j + 1) * (j + 1));
				while (space > 1) {
					sums[sums.length-1][xInitial][yInitial] = 1.0;
					yInitial += 1;
					space -= 1;
				}
				sums[sums.length-1][xInitial][yInitial] = space;

				// Generate orthogonal
				yInitial = points[1][points[0].length-1];
				while (yInitial > 0) {
					yInitial -= 1;
					sums[sums.length-1][xInitial][yInitial] = 1.0;
				}
			} else { // dx>0, dy<0
				// Generate Triangle
				int xInitial = points[0][0] - j - 1;
				int yInitial = points[1][0];
				double space = 0.5 * inclination[dx.length-1] * (j * j - (j + 1) * (j + 1));
				while (space > 1) {
					sums[sums.length-1][xInitial][yInitial] = 1.0;
					yInitial += 1;
					space -= 1;
				}
				sums[sums.length-1][xInitial][yInitial] = space;

				// Generate orthogonal
				yInitial = points[1][0];
				while (yInitial > 0) {
					yInitial -= 1;
					sums[sums.length-1][xInitial][yInitial] = 1.0;
				}
			}
		}

		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				for (int k = 0; k < cells[0].length; k++) {
					cells[j][k] += sums[i][j][k];
				}
			}
		}

		return cells;
	}

	// Display method
	public void displayASCII(double[][] cells) {
		char[] density = new char[5];

		density[0] = 46;
		density[1] = 43;
		density[2] = 111;
		density[3] = 36;
		density[4] = 35;

		for (int j = cells[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < cells.length; i++) {
				if (cells[i][j] == 1) {
					System.out.print(density[4]);
				} else if (cells[i][j] >= 0.75) {
					System.out.print(density[3]);
				} else if (cells[i][j] >= 0.50) {
					System.out.print(density[2]);
				} else if (cells[i][j] >= 0.25) {
					System.out.print(density[1]);
				} else {
					System.out.print(density[0]);
				}
			}
			System.out.println();
		}
	}
}
