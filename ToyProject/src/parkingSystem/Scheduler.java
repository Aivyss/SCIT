package parkingSystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Scheduler {
	private ArrayList<String> timeTable = new ArrayList<String>();
	private String today;
	
	public Scheduler() {
		setToday();
	}
	
	public void setToday() {
		Calendar cal = Calendar.getInstance();
		this.today = "";
		this.today += cal.get(Calendar.YEAR) + "-";
		this.today += (1 + cal.get(Calendar.MONTH)) + "-";
		this.today += cal.get(Calendar.DAY_OF_MONTH) + "-";
		this.today += cal.get(Calendar.HOUR) + "-";
		this.today += cal.get(Calendar.MINUTE) + "-";
		this.today += cal.get(Calendar.SECOND);
	}
	
	// Create TimeBlock
	public void setTimeBlock(String startDay, String endDay) {// yyyy-mm-dd
		// Define variables
		Scanner sc = new Scanner(System.in);
		String[] startSplit = startDay.split("-");
		String[] endSplit = endDay.split("-");
		String DayLength = "";
		
		// Check Status
		if (checkStatus(startDay) == 0) {
			System.out.println("You can't set TimeBlock");
			return;
		}
		
		// Set process
		for (int i=0; i<startSplit.length; i++) {
			DayLength +=startSplit[i];
		}
		DayLength += "-";
		for (int i=0; i<startSplit.length; i++) {
			DayLength +=endSplit[i];
		}
		
		timeTable.add(DayLength);
	}
	
	// check Status
	public int checkStatus(String startDay) { //startDay = "yyyy-mm-dd"		
		// Define variables
		int determinator = 2;
		String[] startDaySplit = startDay.split("-");
		String startDayMerge = "";
		
		// Process 1 (.size() == 0)
		if (timeTable.size() == 0) {
			return -1;
		}
		
		// Process 2 (.size() !=0)
		for (int i=0; i<startDaySplit.length; i++) {
			startDayMerge += startDaySplit[i];
		}
		
		for (int i=0; i<timeTable.size(); i++) {
			String compareStartDay = timeTable.get(i).split("-")[0];
			String compareEndDay = timeTable.get(i).split("-")[1];
			if (startDayMerge.compareTo(compareEndDay) > 0) {
				determinator = -1;
			} else if (startDayMerge.compareTo(compareStartDay) >= 0)  {
				determinator = 0;
			} else {
				if (i == timeTable.size()-1 && determinator == 2) {
					determinator = -1;
				}
			}
		} // for end
		
		return determinator;
	}
	
	
}
