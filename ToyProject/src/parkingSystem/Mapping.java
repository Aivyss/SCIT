package parkingSystem;

import java.util.Calendar;
import java.util.Scanner;

public class Mapping {
	// Member variables
	private final int FLOOR = 4;
	private final int NUMOFPLACE = 100;
	private Scheduler[][] sch = new Scheduler[FLOOR][NUMOFPLACE];
	private String today;
	
	// Constructor
	public Mapping() {
		Calendar cal = Calendar.getInstance();
		this.today = "";
		this.today += cal.get(Calendar.YEAR) + "-";
		this.today += (1 + cal.get(Calendar.MONTH)) + "-";
		this.today += cal.get(Calendar.DAY_OF_MONTH) + "-";
		this.today += cal.get(Calendar.HOUR) + "-";
		this.today += cal.get(Calendar.MINUTE) + "-";
		this.today += cal.get(Calendar.SECOND);
		
		for (int i=0; i<FLOOR; i++) {
			for (int j=0; j<NUMOFPLACE; j++) {
				sch[i][j] = new Scheduler();
			}
		}
	}
	
	// Display usable parking station
	public void display(String startDay, String endDay) {
		for (int i=0; i<FLOOR; i++) {
			System.out.println("[" + (i+1) + " floor]");
			for (int j=0; j<NUMOFPLACE; j++) {
				if (j%10 == 0) {
					System.out.println();
				}
				if (sch[i][j].checkStatus(startDay) == 0) {
					System.out.print("■");
				} else {
					System.out.print("□");
				}
			}
			System.out.println();
			System.out.print("============================"+"\n");
		}
	}
	
	public void position(String startDay, String endDay, String place) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		String[] placeSplit = place.split("-");
		int chosenFloor = Integer.parseInt(placeSplit[0]);
		int chosenPlace = Integer.parseInt(placeSplit[1]);
		
		// Process
		if (sch[chosenFloor-1][chosenPlace-1].checkStatus(startDay) == 0 && sch[chosenFloor-1][chosenPlace-1].checkStatus(endDay) == 0 ) {
			System.out.println("You can use this place.");
			System.out.print("Choose another place: ");
			place = sc.nextLine();
			
			position(startDay, endDay, place);
		} else {
			sch[chosenFloor-1][chosenPlace-1].setTimeBlock(startDay, endDay);
		}
	}
}