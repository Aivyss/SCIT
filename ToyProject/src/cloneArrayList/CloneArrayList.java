package cloneArrayList;

/**
 * 해시오염이 일어날 가능성은 없다. 제네릭으로 하나의 타입만 다루기 때문에!!
 *
 * @param <T>
 */
public class CloneArrayList<T> {
	private Object[] arry;
	private int size;
	
	public CloneArrayList() {
		this.size = 0;
		this.arry = new Object[this.size];
	}
	
	/**
	 * Do not modify this method. 
	 * And DO NOT add any value to arry(Object[] type) for type safety 
	 * except for using this method.
	 * @param t
	 * @return
	 */
	public boolean add(T t) { 
		Object[] temp = new Object[++this.size];
		
		if (size != 0) {
			for(int i=0; i<arry.length; i++) {
				temp[i] = arry[i];
			}
			
			temp[this.size-1] = t;                                    
		} else {
			temp[0] = t;
		}
		
		arry = temp;
		
		return true;
	}
	
	public boolean add(T[] tArray){
		for (T t : tArray) {
			add(t);
		}
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) { 
		
		return (T) arry[index];
	}
	
	public boolean set(int index, T t) {
		arry[index] = t;
		
		return true;
	}
	
	public boolean remove(int index) {
		Object[] temp = new Object[this.size-1];
		boolean flag = false;
		
		if (size !=0) {
			for (int i=index+1; i<this.size; i++) {
				arry[i-1] = arry[i];
			}
			
			for (int i=0; i<temp.length; i++) {
				temp[i] = arry[i];
			}
			arry = temp;
			
			size--;
			flag = true;
		}
		
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean remove(T t) {
		int index = 0;
		boolean flag = false;
		
		if (size !=0) {
			for (T element : (T[]) arry) {
				if (element == t) {
					break;
				}
				
				index++;
			}
			
			flag = remove(index);
		}
		
		return flag;
	}
	
	public int size() {
		
		return this.size;
	}
	
	public boolean isEmpty() {
		
		return this.size==0;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		
		return (T[]) this.arry;
	}
}
