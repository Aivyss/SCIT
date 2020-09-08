package java09082020;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int[] intArry1 = {11, 12, 13, 14, 25, 30, 54, 65, 68 ,77};
		int[] intArry2 = new int[intArry1.length];
		
		// Copy Process
		for (int i=0; i<intArry1.length; i++) {
			intArry2[i] = intArry1[i];
		}
		
		// Output
		System.out.print("원본 배열 : ");
		for (int i=0; i<intArry1.length; i++) {
			System.out.print(intArry1[i] + " ");
		}
		System.out.println();
		System.out.print("복사본: ");
		for (int i=0; i<intArry1.length; i++) {
			System.out.print(intArry2[i] + " ");
		}
	}
}
