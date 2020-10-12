package java10122020.generic;

public class FruitBox<T> { // T -> unknown class, type argument
	private T object;
	
	public T get() {
		return object;
	}
	
	public void set(T object) {
		this.object = object;
	}
}
