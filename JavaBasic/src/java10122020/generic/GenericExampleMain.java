package java10122020.generic;
/**
 * Apple, Graphe - FruitBox - GenericExampleMain
 * @author Aivyss
 *
 */
public class GenericExampleMain {

	public static void main(String[] args) {
		FruitBox<Apple> fb1 = new FruitBox<Apple>();
		fb1.set(new Apple());
		System.out.println(fb1.get().getName());
		
		/**
		 * <!--error--!>
		 * box.set(new Graph());
		 * System.out.println(fb.get().getName());
		 */
		
		FruitBox<Graphe> fb2 = new FruitBox<Graphe>();
		fb2.set(new Graphe());
		System.out.println(fb2.get().getName());
	}

}
