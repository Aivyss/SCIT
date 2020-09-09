package java09092020;

public class ArrayPractice {
	public static void main(String[] args) {
		// Define variables
		int[] intArry1 = {11, 12, 13, 14, 25, 30, 54, 65, 68 ,77};
		int[] intArry2 = new int[intArry1.length];
		int[] intArry3 = intArry1;
		
		// Copy Process
		for (int i=0; i<intArry1.length; i++) {
			intArry2[i] = intArry1[i];
		}
		
		// Output 1 intArry2 == [I@15db9742
		System.out.print("원본 배열 : ");
		for (int i=0; i<intArry1.length; i++) {
			System.out.print(intArry1[i] + " ");
		}
		System.out.println();
		System.out.print("복사본: ");
		for (int i=0; i<intArry1.length; i++) {
			System.out.print(intArry2[i] + " ");
		}
		
		// Output 2 (Address reference, intArry1 == [I@6d06d69c, intArry3 == [I@6d06d69c)
		System.out.println("intArry1 = " + intArry1 + ", intArry3 = " + intArry3);
		intArry1[0] = 0;
		System.out.println("intArry1[0] = " + intArry1[0] + ", intArry3[0] = " + intArry3[0]);
	}
}

