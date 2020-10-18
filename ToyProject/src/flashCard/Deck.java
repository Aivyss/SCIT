package flashCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck {
	// Instances
	Map<String, Card> deck = new HashMap<>();
	CardFormat format;
	int primaryKey;
	
	// Constructor
	public Deck(CardFormat format) {
		this.format = format;
		primaryKey = Create.chooseKey(format);
	}
	
	// Add card to deck
	public void addCard(Card card) {
		deck.put(card.getNameCategoryFront().get(primaryKey), card);
	}
	
}
