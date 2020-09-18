package java09202020;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class PostIt {

	// Basic of PostIt
	private String title;
	private String content;
	private ArrayList<String> tags = new ArrayList<String>();
	private int[] date = new int[6];
	// [0]: year [1]: month [2]: date [3]: hour [4]: minute [5]: second

	// To do List ON/OFF
	private boolean toDoOnOFF;
	private boolean toDo;

	// Pin view ON/OFF
	private boolean pin;

	// Alert ON/OFF
	boolean alertOnOff;
	int[] alertDate = new int[6];

	// Constructor
	public PostIt() {
		Calendar date = Calendar.getInstance();
		this.date[0] = date.get(Calendar.YEAR);
		this.date[1] = 1+date.get(Calendar.MONTH);
		this.date[2] = date.get(Calendar.DAY_OF_MONTH);
		this.date[3] = date.get(Calendar.HOUR);
		this.date[4] = date.get(Calendar.MINUTE);
		this.date[5] = date.get(Calendar.SECOND);
	}

	// PostItView Method
	public void postItView() {
		if (toDoOnOFF) {
			if (toDo) {
				System.out.print("/   /");
			} else {
				System.out.print("/ V /");
			}
		}

		System.out.println("Title : " + title);
		System.out.println("content : " + content);

		for (int i = 0; i < tags.size(); i++) {
			System.out.println("tag" + (i + 1) + ": " + tags.get(i));
		}
		
		System.out.print("Created Date : ");
		for (int i = 0; i < date.length; i++) {
			System.out.print(date[i]);
			if (i != date.length - 1) {
				System.out.print("-");
			}
		}
		System.out.println();

		if (pin) {
			System.out.print("Pin : O");
		} else {
			System.out.print("Pin : X");
		}
		System.out.println();

		if (alertOnOff) {
			for (int i = 0; i < alertDate.length; i++) {
				System.out.print(date[i]);
				if (i != date.length - 1) {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	} // PostItView method end

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

	// tag getter
	public ArrayList<String> getTag() {
		return tags;
	}
}
