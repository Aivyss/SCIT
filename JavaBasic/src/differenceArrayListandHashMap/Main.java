package differenceArrayListandHashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassA b = new ClassA();
		ClassA c = new ClassA();
		
		a.setA(1);
		b.setA(2);
		c.setA(3);
		
		ArrayList<ClassA> list = new ArrayList<>();
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		for (ClassA vo : list) {
			System.out.println(vo.getA());
		}
		System.out.println("===========================");
		
		list.get(0).setA(4);
		list.get(1).setA(5);
		list.get(2).setA(6);
		
		for (ClassA vo : list) {
			System.out.println(vo.getA());
		}
		System.out.println("===========================");
		
		HashMap<Integer, ClassA> map = new HashMap<>();
		map.put(1, a);
		map.put(2, b);
		map.put(3, c);
		
		for (Integer num : map.keySet()) {
			System.out.println(num);
		}
		System.out.println("===========================");
		
		map.get(1).setA(7);
		map.get(2).setA(8);
		map.get(3).setA(9);
		
		for (Integer num : map.keySet()) {
			System.out.println(num);
		}
		System.out.println("===========================");
	}
}
