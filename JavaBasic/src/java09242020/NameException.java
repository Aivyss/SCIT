package java09242020;

public class NameException extends Exception {
	public NameException() {
		super("이름 초과"); // == new Exception("이름 초과");
	}
	
}
