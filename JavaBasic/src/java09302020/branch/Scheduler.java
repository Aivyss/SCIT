package java09302020.branch;

import java.util.ArrayList;
import java.util.Calendar;

public class Scheduler {
	private ArrayList<Object> timeTable = new ArrayList<Object>();
	private String today;
	
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
	
	public void setTimeTable(String startDate, String endDate) {// yyyy-mm-dd
		
	}

}
