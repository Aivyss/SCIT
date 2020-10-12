package java10122020.problem;

public class ClassB extends ClassA {
	int b;
	int c;
	
	ClassB (int b, int c) {
		super(c, b);
		super.b = this.b - 4;
		this.c = a + b + c; // 12+24+12
	}
}
