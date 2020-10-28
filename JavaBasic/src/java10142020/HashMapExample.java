
package java10142020;

import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
/**
 * 1. Collection
 * 	1.1. Set
 * 	1.2. List
 * 2. Map
 * 
 * <!-- HashMap methods --!>
 * .put(K, V) method example
 * .keySet()
 * .entrySet()
 * .remove(K)
 * .clear()
 * .get(K)
 */
public class HashMapExample {

	public static void main(String[] args) {
		// Define HashMap instance
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		
		// .put(K, V) method
		for (int i=33; i<100; i++) {
			map.put(i, (char) i);
		}
		System.out.println(map);
		
		// .remove(K) method
		map.remove(33);
		System.out.println(map);
		
		
		// .get(K) method1 - .keySet();
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println(map.get(i));
		}
		
		// .get(K) method2 - .entrySet();
		Set<Entry<Integer, Character>> ent = map.entrySet();
		for (Entry<Integer, Character> e : ent) {
			System.out.println("Key : " + e.getKey() + ", Value : " + e.getValue());
		}
		
		// .clear() method
		map.clear();
		System.out.println(map);
	}

}
