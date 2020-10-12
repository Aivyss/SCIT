package java10122020.generic;
/**
 * Pair - OrderedPair - PairMain
 * @author Aivyss
 *
 */
public class PairMain {

	public static void main(String[] args) {
		OrderedPair<String, Integer> pair1 = new OrderedPair<String, Integer>("Even", 8);
		OrderedPair<String, String> pair2 = new OrderedPair<String, String>("Hello", "World");
		
		System.out.println(pair1.getKey() + pair1.getValue());
		System.out.println(pair2.getKey() + pair2.getValue());
	}

}
