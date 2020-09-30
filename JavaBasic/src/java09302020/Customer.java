package java09302020;

import java.util.Scanner;

public class Customer {
	// Member variables
	private String name;
	private String phone;
	private String carNum;
	private String place; // floor-space
	private String startDate;
	private String endDate;
	
	// Sign up Process (Constructor)
	public Customer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력: ");
		this.name = sc.nextLine();
		System.out.print("차 번호를 입력: ");
		this.carNum = sc.nextLine();
		System.out.print("전화번호를 입력: ");
		this.phone = sc.nextLine();
		System.out.print("시작일 입력: ");
		this.startDate = sc.nextLine();
		System.out.print("종료일 입력: ");
		this.endDate = sc.nextLine();
		System.out.print("위치를 입력: ");
		this.place = sc.nextLine();

	}
	
	// Getter method
	public String getPhone() {
		return phone;
	}
	
	public String getPlace() {
		return place;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

	// Display method
	public void display() {
		System.out.println("이름 : " + this.name);
		System.out.println("차 번호 : " + this.carNum);
		System.out.println("전화번호 : " + this.phone);
		System.out.println("위치 : " + this.place);
	}
}
