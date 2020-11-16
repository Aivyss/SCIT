
public class Main {

	public static void main(String[] args) {
		Logger2 logger = new Logger2(Main.class);
		
		Exception e = new Exception();
		
		logger.autoLog(false, e, "오류테스트");
	}

}
