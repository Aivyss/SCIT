package java10082020;

public class Child extends Parent {
	// 자식 클래스에만 있는 멤버변수 
	protected boolean flag;
	
	// 부모 클래스에는 있으나 오버라이딩 된 메소드
	public String methodC(){
		return "Method Overrided";
	}
	
	// 자식 클래스에만 있는 메소드
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
