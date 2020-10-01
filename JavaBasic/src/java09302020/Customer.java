package java09302020;

import java.util.Scanner;

public class Customer {
	// Member variables
	private String name;
	private String phone;
	private String carNum;
	private String place; // floor-space
	private String startDay;
	private String endDay;
	
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
		this.startDay = sc.nextLine();
		System.out.print("종료일 입력: ");
		this.endDay = sc.nextLine();
		

	}
	
	// Positioning
	public void position(Mapping mapp) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		
		// display panel
		mapp.display(this.startDay, this.endDay);
		
		// select process
		System.out.println();
		System.out.print("위치를 입력: "); // floor-place
		this.place = sc.nextLine();
		
		mapp.position(this.startDay, this.endDay, this.place);
	}
	
	// Display method
	public void display() {
		System.out.println("이름 : " + this.name);
		System.out.println("차 번호 : " + this.carNum);
		System.out.println("전화번호 : " + this.phone);
		System.out.println("위치 : " + this.place);
	}
	
	// Getter method
	public String getPhone() {
		return phone;
	}
	
	public String getPlace() {
		return place;
	}
	
	public String getStartDay() {
		return startDay;
	}
	
	public String getEndDay() {
		return endDay;
	}
}
