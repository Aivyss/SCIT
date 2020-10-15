package flashCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Deck {

	// Time deviation settings
	public final double RESET = 0;
	public double difficultMult = 1.2;
	public double goodMult = 1.5;
	public double easyMult = 2.0;

	// Card Nameplate
	List<String> frontPlate;
	List<String> backPlate;
	
	// Deck
	Map<FlashCard<List<String>, List<String>>, FlashCard<List<String>, List<String>>> deck = new HashMap<>();
	
	// Scheduler
	List<String> schedule = new ArrayList<>();
	
	// Constructor
	public Deck() {
		frontPlate = Create.createFrontPlate();
		backPlate = Create.createBackPlate();
	}
	
	public void addCard() {
		FlashCard<List<String>, List<String>> front = Create.createFront(frontPlate);
		FlashCard<List<String>, List<String>> back = Create.createFront(backPlate);
		
		deck.put(front, back);
	}
	
}
