package java09042020;

public class Problem2 {
	public static void main(String[] args) {
		// Define variables
		int books = 1000*300;
		int numberOfPeople = 2;
		int day = 0; // 일차
		
		while(true) {
			books -= numberOfPeople*30;
			day++;
			
			if (day%10 == 0) {
				numberOfPeople*=2;
			}
			if (books<=0) {
				break;
			}
		}
		System.out.println("책을 다 읽을 때까지 "+ day + "일 " + numberOfPeople + "명입니다.");
	}
}
