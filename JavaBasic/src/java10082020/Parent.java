package java10082020;

public class Parent {
	protected int num;
	protected String str;
	
	public Parent() { 
		/** 
		 * default constructor가 없으면 상속시 오류가 난다.
		 * 특정 constructor가 있는 경우 default는 묵시적으로 생기지 않음
		 * 따라서 명시적으로 따로 만들어야 한다.
		 */
	}
	
	public Parent(int num, String str) {
		this.num = num;
		this.str = str;
	}
	
	public void methodA() {
		
	}
	
	public int methodB() {
		return 1;
	}
	
	public String methodC() {
		return "before";
	}
}
