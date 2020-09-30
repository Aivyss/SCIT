package java09302020.branch;

import java.util.Calendar;
import java.util.Scanner;

import java09302020.Customer;

public class Mapping {
	// Member variables
	private Customer[] customer;
	private final int FLOOR = 4;
	private final int NUMOFPLACE = 100;
	private int[][] place = new int[FLOOR][NUMOFPLACE];
	private String[][] startDate = new String[FLOOR][NUMOFPLACE];
	private String[][] endDate = new String[FLOOR][NUMOFPLACE];
	private String date;
	
	// Constructor
	public Mapping(Customer[] customer) {
		Calendar cal = Calendar.getInstance();
		date = "";
		date += cal.get(Calendar.YEAR) + "-";
		date += (1 + cal.get(Calendar.MONTH)) + "-";
		date += cal.get(Calendar.DAY_OF_MONTH) + "-";
		date += cal.get(Calendar.HOUR) + "-";
		date += cal.get(Calendar.MINUTE) + "-";
		date += cal.get(Calendar.SECOND);
	}
	
	// place display method
	public void display() {
		for (int i=0; i<FLOOR; i++) {
			System.out.println("======[" + i + "floor]=====");
			for (int j=0; j<NUMOFPLACE; j++) {
				if ((j+1)%20 == 0) {
					System.out.println();
				}
				
				if (place[i][j] == 1) {
					System.out.print("■");
				} else {
					System.out.print("□");
				}
			}
			System.out.println();
		}
	}
	
	// take place method
	public void takePlace(Customer customer) {
		checkStart(customer);
		display();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("지정자리를 고르세요: ");
		String place = sc.nextLine();
		int floor= Integer.parseInt(place.split("-")[0]);
		int space= Integer.parseInt(place.split("-")[1]);
		
	}
	
	
	// startCheck, endCheck	method
	public void checkStart(Customer customer) {
		String[] customerPlace = customer.getPlace().split("-");
		int floor = Integer.parseInt(customerPlace[0]);
		int place = Integer.parseInt(customerPlace[1]);
		
		if (startDate[floor-1][place].compareTo(this.date)>0) {
			this.place[floor-1][place] = 0;
		} else {
			this.place[floor-1][place] = 1;
		}
	}
	
	public void checkEnd(Customer customer) {
		String[] customerPlace = customer.getPlace().split("-");
		int floor = Integer.parseInt(customerPlace[0]);
		int place = Integer.parseInt(customerPlace[1]);
		
		if (endDate[floor-1][place].compareTo(this.date)>=0) {
			this.place[floor-1][place] = 1;
		} else {
			this.place[floor-1][place] = 0;
		}
	}
	
	// Setter and Getter
	public String[][] getStartDate() {
		return startDate;
	}

	public void setStartDate(String[][] startDate) {
		this.startDate = startDate;
	}

	public String[][] getEndDate() {
		return endDate;
	}

	public void setEndDate(String[][] endDate) {
		this.endDate = endDate;
	}
	
}
