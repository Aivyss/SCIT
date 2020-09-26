package postIt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class PostIt {
	// Basic of PostIt
	private String title;
	private String content;
	private ArrayList<String> tags = new ArrayList<String>();
	private String date;

	// To do List ON/OFF
	private boolean toDoOnOFF;
	private ArrayList<Boolean> toDoBox = new ArrayList<Boolean>();
	private ArrayList<String> toDoContent = new ArrayList<String>();

	// Pin view ON/OFF
	private boolean pin;

	// Alert ON/OFF
	boolean alertOnOff;
	String alertDate;

	// Constructor
	public PostIt() {
		Calendar date = Calendar.getInstance();
		this.date = "";
		this.date += date.get(Calendar.YEAR) + "-";
		this.date += (1 + date.get(Calendar.MONTH)) + "-";
		this.date += date.get(Calendar.DAY_OF_MONTH) + "-";
		this.date += date.get(Calendar.HOUR) + "-";
		this.date += date.get(Calendar.MINUTE) + "-";
		this.date += date.get(Calendar.SECOND);
	}

	// PostItView Method
	public void postItView() {
		// Basic Post-it information
		System.out.println("Title : " + title);
		System.out.println("content : " + content);

		// To-do status
		if (toDoOnOFF) {
			for (int i = 0; i < toDoBox.size(); i++) {
				if (toDoBox.get(i)) {
					System.out.print("/   /" + " ");
					System.out.println(toDoContent.get(i));
				} else {
					System.out.print("/ V /" + " ");
					System.out.println(toDoContent.get(i));
				}
			}
		}
		
		// tag status
		for (int i = 0; i < tags.size(); i++) {
			System.out.println("tag" + (i + 1) + ": " + tags.get(i));
		}
		
		// Date
		System.out.print("Created Date : ");
		System.out.println(date);

		// print Pin status
		if (pin) {
			System.out.print("Pin : O");
		} else {
			System.out.print("Pin : X");
		}
		System.out.println();

	}

	// writePostIt Method
	public void writePostIt() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Title : ");
		title = sc.nextLine();
		System.out.print("Content : ");
		content = sc.nextLine();
	} // writePostIt method end

	// addTag Method
	public void addTag() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Tag : ");
		tags.add(sc.nextLine());
	}
	
	// addTag Method
	public void addToDoContent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("To-Do Content : ");
		toDoContent.add(sc.nextLine());
		toDoBox.add(true);
	}

	// Getters and Setters
	public ArrayList<String> getTag() {
		return tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getDate() {
		return date;
	}

	public boolean isToDoOnOFF() {
		return toDoOnOFF;
	}

	public boolean isPin() {
		return pin;
	}

	public void setPin(boolean pin) {
		this.pin = pin;
	}

	public void setToDoOnOFF(boolean toDoOnOFF) {
		this.toDoOnOFF = toDoOnOFF;
	}

	public void setToDoBox(ArrayList<Boolean> toDoBox) {
		this.toDoBox = toDoBox;
	}

	public void setToDoContent(ArrayList<String> toDoContent) {
		this.toDoContent = toDoContent;
	}

	public boolean isAlertOnOff() {
		return alertOnOff;
	}

	public void setAlertOnOff(boolean alertOnOff) {
		this.alertOnOff = alertOnOff;
	}

	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<Boolean> getToDoBox() {
		return toDoBox;
	}

	public ArrayList<String> getToDoContent() {
		return toDoContent;
	}
}
