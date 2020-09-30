package java09302020;

import java.util.Scanner;

public class CustomerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer[] custm = new Customer[10000];
		int numCount = 0;
		
		// Display part
		while(true) {
			System.out.println("==================");
			System.out.println("1. 예약");
			System.out.println("2. 조회");
			System.out.println("3. 전체출력");
			System.out.println("4. 프로그램종료");
			System.out.println("==================");
			System.out.print("선택 : ");
			int selector = sc.nextInt();
			
			if(selector == 1) { // Reservation part
				if (numCount>=10000) {
					System.out.println("예약할 수 있는 고객의 수를 초과했습니다.");
					System.out.println("다른 메뉴를 선택하세요.");
				} else {
					custm[numCount] = new Customer();
					numCount++;
				}
			} else if (selector == 2) {
				sc.nextLine();
				System.out.print("전화번호를 입력: ");
				String searchNum = sc.nextLine();
				for (int i=0; i<numCount; i++) {
					if(searchNum.equals(custm[i].getPhone())) {
						custm[i].display();
						break;
					}
					
					if(i == numCount-1) {
						System.out.println("검색결과가 없습니다");
					}
				}
			} else if (selector == 3) {
				System.out.println("===================");
				for (int i=0; i<numCount; i++) {
					custm[i].display();
					System.out.println("===================");
				}
			} else if (selector == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;	
			} else {
				System.out.println("다시 선택하십시오.");
				continue;
			}
		}
	} // main method end
}
