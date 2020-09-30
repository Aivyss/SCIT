package java09302020;

import java.util.Calendar;

public class Memo {

	public static void main(String[] args) {
		String test1 = new String("2020-09-28");
		String test2 = new String("2020-09-30");
		
		System.out.println(test1.compareTo(test2));
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2020, 9, 25);
		System.out.println(cal.getTime());
		cal.add(Calendar.DATE, 42);
		System.out.println(cal.getTime());
	}

}
