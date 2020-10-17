package flashCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Create {
	
	static List<String> createCategory() {
		Scanner sc = new Scanner(System.in);
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
}
