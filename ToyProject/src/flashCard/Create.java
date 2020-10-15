package flashCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Create {
	
	static List<String> createFrontPlate() {
		Scanner sc = new Scanner(System.in);
		List<String> frontPlate = new ArrayList<>();
		
		while (true) {
			System.out.print("Input space name : ");
			frontPlate.add(sc.nextLine());
			
			System.out.print("Do you want to stop? (Y/N):");
			String selector = sc.nextLine();
			if ("Y".equals(selector)) {
				break;
			}
		}
		
		return frontPlate;
	}
	
	static List<String> createBackPlate() {
		Scanner sc = new Scanner(System.in);
		List<String> backPlate = new ArrayList<>();
		
		while (true) {
			System.out.print("Input space name : ");
			backPlate.add(sc.nextLine());
			
			System.out.print("Do you want to stop? (Y/N):");
			String selector = sc.nextLine();
			if ("Y".equals(selector)) {
				break;
			}
		}
		
		return backPlate;
	}
	
	static FlashCard<List<String>, List<String>> createFront(List<String> np) {
		List<String> inf = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i<np.size(); i++) {
			System.out.print(np.get(i) + " : ");
			inf.add(sc.nextLine());
		}
		
		FlashCard<List<String>, List<String>> front = new FlashCard<>(np, inf);
		
		return front;
	}
	
	static FlashCard<List<String>, List<String>> createBack(List<String> np) {
		List<String> inf = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i<np.size(); i++) {
			System.out.print(np.get(i) + " : ");
			inf.add(sc.nextLine());
		}
		
		FlashCard<List<String>, List<String>> back = new FlashCard<>(np, inf);
		
		return back;
	}

}
