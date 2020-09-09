// 정수 값 29, 37 , 12 , 45 ,60 을 가지고 있는 배열이 있다. 
// 인덱스가 3인 곳은 출력하지 말고 나머지만 출력하시오.
package java09092020;

public class Problem1 {
	public static void main(String[] args) {
		// Define variables
		int[] arry = {29, 37 , 12 , 45 ,60};
		
		// Output
		for(int i=0; i<arry.length; i++) {
			if(i != 3) {
				System.out.println(arry[i]);
			}
		}
	}
}
