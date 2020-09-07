package java09072020;

public class Problem1Branch {
	public static void main(String[] args) {
		// Define variables
		int[] arry = new int[50];
		int count = 1;
		
		// Choice Process
		for (int i=0; i<arry.length; i++) {
			if (count%2 !=0) {
				arry[i] = count;
			} else {
				i--;
			}
			count++;
		}
		
		// Output Process
		for (int i=0; i<arry.length; i++) {
			System.out.println(i+1 + "번째의 수 : " + arry[i]);
		}
	}

}
