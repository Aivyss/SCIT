package java09202020;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] st = new Student[10];
		int count = 0;
		while (count<10) {
			System.out.println("===============");
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("0. 종료");
			System.out.println("===============");
			System.out.print("메뉴를 입력해 주세요 >");
			int selector = sc.nextInt();
			
			
			if (selector == 1) {
				st[count] = new Student();
				sc.nextLine();
				System.out.println("[ 학생 정보 입력 ]");
				System.out.print("학생 이름 : ");
				st[count].setName(sc.nextLine());
				
				System.out.print("국어 점수 : ");
				st[count].setKor(sc.nextInt());
				
				System.out.print("영어 점수 : ");
				st[count].setMat(sc.nextInt());
				
				System.out.print("수학 점수 : ");
				st[count].setEng(sc.nextInt());
				
				count++;
				
			} else if(selector == 2) {// Output Process
				for (int i=0; i<count; i++) {
					System.out.println(st[i].getName()+"님의 총점은 " + st[i].getSum() + "점 이고 평균은 " + st[i].getAvg() + "점 입니다.");
				}
			} else if (selector == 0) { // Shutdown Process
				break;
			}
		} // while end
		
		sc.close();
	} // main method end
}
