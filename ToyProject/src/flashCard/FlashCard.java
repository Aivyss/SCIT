package flashCard;

public class FlashCard<NamePlate, Information> {
	public NamePlate namePlate;
	public Information information;
	
	public FlashCard(NamePlate np, Information inf) {
		namePlate = np;
		information = inf;
	}
}
