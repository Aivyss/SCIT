package postIt;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PostItMain {
	public static void main(String[] args) {
		// Define instances
		PostItStorage storage = new PostItStorage();
		PostIt tempPostIt;
		Scanner sc = new Scanner(System.in);
		final String pathName = "src" + File.separator + "storage" + File.separator + "PostItStorage.txt";
		// Define variables
		int selector;

		// Menu select
		while (true) {
			System.out.println("====================================");
			System.out.println("1. Write Post it");
			System.out.println("2. View all Post it");
			System.out.println("3. View tag selected Post it");
			System.out.println("4. Save Post it");
			System.out.println("5. Read Post it");
			System.out.println("6. exit");
			System.out.println("====================================");
			System.out.print("Select menu : ");
			selector = sc.nextInt();

			if (selector == 1) {
				tempPostIt = new PostIt();
				
				// write basic information
				tempPostIt.writePostIt();
				
				// write tag information
				while (true) {
					System.out.print("Do you want to add tag? (1/0): ");
					int check = sc.nextInt();
					if (check == 1) {
						tempPostIt.addTag();
					} else {
						break;
					}
				}
				
				// write to-do status
				System.out.print("Do you want to switch on To-Do? (1/0): ");
				int check = sc.nextInt();
				sc.nextLine();
				
				if (check == 1) {
					tempPostIt.setToDoOnOFF(true);
					while (true) {					
						System.out.print("Do you want to add toDo? (1/0): ");
						check = sc.nextInt();
						if (check == 1) {
							tempPostIt.addToDoContent();
						} else {
							break;
						}
					}
				} else {
					tempPostIt.setToDoOnOFF(false);
				}

				storage.store(tempPostIt);
			} else if (selector == 2) {
				ArrayList<PostIt> tempStorage = storage.getStorage();
				for (int i = 0; i < tempStorage.size(); i++) {
					tempPostIt = tempStorage.get(i);
					tempPostIt.postItView();
				}
			} else if (selector == 3) {
				PostItTagCollector collector = new PostItTagCollector(storage);
				sc.nextLine();
				System.out.print("Input Tag Name > ");
				String tag = sc.nextLine();

				collector.tagView(tag);
			} else if (selector == 4) {
				storage.writeFile(pathName);
			} else if (selector == 5) {
				storage.readFile(pathName);
			} else if (selector == 6) {
				break;
			}
		}

		sc.close();
	}
}
