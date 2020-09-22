package java09212020;

public class AccessModifierMain {

	public static void main(String[] args) {
		AccessModifier am1 = new AccessModifier();
		AccessModifier am2 = new AccessModifier();
		
		// am1.age = 30; private라서 직접접근 불가
		// test는 default라서 직접접근이 가능하게 됨
		am2.test = 123456789;
 		int getAge1 = am1.getAge();
 		am1.setAge(50);
 		int getAge2 = am2.getAge();
 		System.out.println(getAge1);
 		System.out.println(getAge2);
 		System.out.println(am1.test);
 		System.out.println(am2.test);
	}

}
