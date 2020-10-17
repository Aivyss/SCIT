package java10142020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("1010", 25);
		map.put("1011", 35);
		map.put("1012", 45);
		
		System.out.println(map.get("1013")); // null
		System.out.println(map);
		
		Set<String> keys = map.keySet(); // Create Keyset HashSet.
		for (String e : keys) {
			System.out.println(map.get(e));
		}
	}

}
