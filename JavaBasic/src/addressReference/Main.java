package addressReference;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassA b = new ClassA();
		ClassA c = new ClassA();
		
		HashMap<Integer, ClassA> map = new HashMap<>();
		ArrayList<ClassA> list = new ArrayList<>();
		map.put(1, a);
		map.put(2, b);
		map.put(3, c);
		
		list.add(map.get(1));
		list.add(map.get(2));
		list.add(map.get(3));
		
		for (Integer num : map.keySet()) {
			System.out.println(num);
		}
		System.out.println("===========================");
		
		ClassA d = list.get(0);
		ClassA e = list.get(1);
		ClassA f = list.get(2);
		
		d.setA(4);
		e.setA(5);
		f.setA(6);
		
		for (Integer num : map.keySet()) {
			System.out.println(map.get(num).getA());
		}
		System.out.println("===========================");
	}
}
