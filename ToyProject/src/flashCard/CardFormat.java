package flashCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardFormat {
	List<String> frontCategory = new ArrayList<>();
	List<String> backCategory = new ArrayList<>();
	
	// Constructor
	public CardFormat() {
		
	}
	
	// create CardFormat
	public void createFormat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Create front Category");
		frontCategory = Create.createCategory();
		System.out.println("Create back Category");
		backCategory = Create.createCategory();
	}
	
	// Getter
	public List<String> getFrontCategory() {
		return frontCategory;
	}

	public List<String> getBackCategory() {
		return backCategory;
	}
	
	
}
