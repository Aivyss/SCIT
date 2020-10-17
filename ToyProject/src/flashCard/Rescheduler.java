package flashCard;

import java.util.List;

public interface Rescheduler {
	// Rescheduler variables
	public boolean cardState = false; // true -> review, false -> new card
	
	// Rescheduler method
	public String reschedule(String scheduler, String button);

}
