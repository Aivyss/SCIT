package flashCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {
	// Instances
	CardFormat format = new CardFormat();
	protected List<String> nameCategoryFront = format.frontCategory;
	protected List<String> nameCategoryBack = format.backCategory;
	protected List<String> informationFront = new ArrayList<>();
	protected List<String> informationBack = new ArrayList<>();
	
	// Constructor
	public Card(CardFormat format) {
		this.format = format;
	}
	
	// Input information
	public void inputInformation() {
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<this.nameCategoryFront.size(); i++) {
			System.out.print(this.nameCategoryFront.get(i) + ": ");
			this.informationFront.add(sc.nextLine());
		}
		
		for (int i=0; i<this.nameCategoryBack.size(); i++) {
			System.out.print(this.nameCategoryBack.get(i) + ": ");
			this.informationBack.add(sc.nextLine());
		}
	}

	// Getter
	public List<String> getNameCategoryFront() {
		return nameCategoryFront;
	}

	public List<String> getNameCategoryBack() {
		return nameCategoryBack;
	}

	public List<String> getInformationFront() {
		return informationFront;
	}

	public List<String> getInformationBack() {
		return informationBack;
	}
	
}
