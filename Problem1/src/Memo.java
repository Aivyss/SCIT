import java.util.ArrayList;

public class Memo {
	public static void main(String[] args) {
		ArrayList<ClassA> list = new ArrayList<>();
		ClassB b = new ClassB();
		ClassC c = new ClassC();
		
		list.add(b);
		list.add(c);
		
		System.out.println(list.get(0) instanceof ClassC);
	}
}

class ClassA {
	
}

class ClassB extends ClassA{
	
}

class ClassC extends ClassA {
	
}
