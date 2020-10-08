package java10082020;

public class PolymorphicExampleMain {

	public static void main(String[] args) {
		Parent p0 = new Parent();
		Parent p1 = new Child();
		Child p2 = new Child();		
		// 자료형의 크기가 부모가 더 크다
		/** Child p3 = new Parent(); *///--> Error
		
		// 부모 클래스에 존재하지 않는 멤버변수
		/** System.out.println(p1.flag); *///--> Error
		System.out.println(p2.flag);
		
		// 부모 클래스에는 존재 하지 않는 메소드
		/** p1.setFlag(false); *///--> Error
		p2.setFlag(true);
		
		// 양쪽 메소드에 존재하나 오버라이딩이 된 메소드의 활용
		System.out.println(p0.methodC()); // 오버라이딩 되기 전 메소드
		System.out.println(p1.methodC()); // 오버라이딩 된 후 메소드 (주목할 부분, 가상메소드)
		System.out.println(p2.methodC()); // 오버라이딩 된 후 메소드
	}

}
