package postIt;

import java.util.ArrayList;
import java.util.Scanner;

public class PostItMain {
	public static void main(String[] args) {
		// Define instances
		PostItStorage storage = new PostItStorage();
		PostIt tempPostIt;
		Scanner sc = new Scanner(System.in);
		
		// Define variables
		int selector;
		
		// Menu select
		while (true) {
			System.out.println("====================================");
			System.out.println("1. Write Post it");
			System.out.println("2. View all Post it");
			System.out.println("3. View tag selected Post it");
			System.out.println("4. exit");
			System.out.println("====================================");
			System.out.print("Select menu : ");
			selector = sc.nextInt();
			
			if (selector == 1) {
				tempPostIt = new PostIt();
				tempPostIt.writePostIt();
				
				while (true) {
					System.out.print("Do you want to add tag? (1/0): ");
					int check = sc.nextInt();
					if (check == 1) {
						tempPostIt.addTag();
					} else {
						break;
					}
				}
				
				storage.store(tempPostIt);
			} else if (selector == 2) {
				ArrayList<Object> tempStorage = storage.getStorage();
				for (int i=0; i<tempStorage.size(); i++) {
					tempPostIt = new PostIt();
					tempPostIt = (PostIt) tempStorage.get(i);
					tempPostIt.postItView();
				}
			} else if (selector == 3) {
				PostItTagCollector collector = new PostItTagCollector(storage);
				sc.nextLine();
				System.out.print("Input Tag Name > ");
				String tag = sc.nextLine();
				
				collector.tagView(tag);
			} else if (selector == 4) {
				break;
			}
		}

		sc.close();
	}
}
