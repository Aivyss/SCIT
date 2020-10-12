package java10122020.generic;
/**
 * PairMain - OrderedPair <-- Pair
 * 
 * @author Aivyss
 *
 * @param <K>
 * @param <V>
 */
public class OrderedPair<K, V> implements Pair<K, V> {
	// Member variables
	private K key;
	private V value;
	
	// Constructor
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	// Method Override
	@Override
	public K getKey() {
		return this.key;
	}
	
	@Override
	public V getValue() {
		return this.value;
	}
}
