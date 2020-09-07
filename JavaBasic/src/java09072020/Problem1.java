package java09072020;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[50];
		int count = 1;
		int i =0;
		int j =1;
		
		// choice Odd number
		while(count<=100) {
			if (count%2 !=0) {
				arry[i] = count;
				System.out.println(j + " 번째의 수 : " + arry[i]);
				j++;
			}
			i++;
			count ++;
		}
	}
}
