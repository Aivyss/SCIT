package java09032020;

public class Problem15 {
	public static void main(String[] args) {
		// Define variables
		int count = 0;
		int sum = 0;
		// Process
		while (sum<5000) {
			count++;
			sum+=count;
		}
		System.out.println("1 ~ " + (count) + "까지의 합계 : " + sum);
	}
}
