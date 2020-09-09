package java09092020;

public class SnakeProblem {
	public static void main(String[] args) {
		// Define variables
		int roomSize = 10;
		int lengthOfSnake = 5;
		int[][] room = new int[roomSize][roomSize];

		// Input Process
		for (int i = 0; i < room[0].length; i++) {
			if (i <= lengthOfSnake) {
				room[i][0] = 1;
			}
		}

		// Process (Time evolution)
		int i = 0;
		while (i < 100) {
			clearScreen();
			room = snakeMove(room);
			print(room, roomSize);
			// while break
			if (check(room, roomSize) == false) {
				break;
			}

			try { // Time evolutions
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			i++;
		}

	} // Main method end

	// Time evolution method
	public static int[][] snakeMove(int[][] room) {
		int[][] evolv = new int[room[0].length][room[0].length];
		int endPoint = room[0].length - 1;

		for (int i = 0; i < room[0].length; i++) {
			for (int j = 0; j < room[0].length; j++) {
				if (i == endPoint) {
					if (j == 0) {
						evolv[endPoint][1] = room[endPoint][0];
					} else if (j == endPoint) {
						evolv[endPoint - 1][endPoint] = room[endPoint][endPoint];
					} else {
						evolv[i][j + 1] = room[i][j];
					}
				} else if (i == 0) {
					if (j == 0) {
						evolv[1][0] = room[0][0];
					} else if (j == endPoint) {
						evolv[0][endPoint - 1] = room[0][endPoint];
					} else {
						evolv[i][j - 1] = room[i][j];
					}
				} else if (j == 0 || j == endPoint) {
					if (j == 0) {
						evolv[i + 1][0] = room[i][0];
					} else if (j == endPoint) {
						evolv[i - 1][endPoint] = room[i][endPoint];
					}
				}
			} // for 2 end
		} // for 1 end
		return evolv;
	}

	// Check the condition method
	public static boolean check(int[][] cells, int scale) {
		int count = 0;
		for (int i = 0; i < scale; i++) {
			for (int j = 0; j < scale; j++) {
				// System.out.print(cells[i][j]);
				if (cells[i][j] == 1) {
					count++;
				}
			}
			// System.out.println();
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
