package java10142020;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// Define HashSet
		Set<String> set = new HashSet<>();
		
		// .add() method
		String[] arr = new String[5];
		for (int i=0; i<5; i++) {
			arr[i] = "Hello".split("")[i];
			set.add(arr[i]);
		}
		
		System.out.println(set);
		
		// .remove() method
		set.remove("o");
		System.out.println(set);
		
		// .iterator() method Set의 원소를 출력하는 interface
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		/**
		 * (1) T/F 판별
		 * (2) T일시 while 반복 
		 * (3) .next()로 값넘김 
		 * (4) 출력 
		 */
	}

}
