package flashCard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Create {
	static public Scanner sc = new Scanner(System.in);
	
	static List<String> createCategory() {
		List<String> category = new ArrayList<>();
		
		while (true) {
			System.out.print("Input space name : ");
			category.add(sc.nextLine());
			
			System.out.print("Do you want to stop? (Y/N):");
			String selector = sc.nextLine();
			if ("Y".equals(selector)) {
				break;
			}
		}
		
		return category;
	}
	
	// Choose primary Key
	static int chooseKey(CardFormat format) {
		int selectIndex = 0;
		for (int i=0; i<format.getFrontCategory().size(); i++) {
			System.out.print(i + ": " + format.getFrontCategory().get(i) + "\t");
		}
		System.out.print("Choose view front : ");
		selectIndex = sc.nextInt();
		
		return selectIndex;
	}
	
	// get Today
	static String getToday() {
		String today = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd")
		
		return today;
	}
}
