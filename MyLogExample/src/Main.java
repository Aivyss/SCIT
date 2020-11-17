import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class);
		Logger2 logger2 = Logger2.getLogger2(Main.class);
		Exception e = new Exception();
		
		logger2.fatal("오류테스트2", e);
		logger2.autoLog(true, e, "오류테스트");
	}

}
