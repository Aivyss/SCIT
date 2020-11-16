package ppulzit;

public class TestMain {

	public static void main(String[] args) {
		Wrapping log = new Wrapping(TestMain.class);
		
		log.logPrint("Warn", "후아아아앙아앙");
		log.getLogger().warn("아 어려워");
		ArithmeticException e = new ArithmeticException("예외처리");
		log.getLogger().warn("난누군가", e);
		log.logPrint("Warn", e,"logPrint(String type, Throwable t, Object ...message)");
		log.logPrint("Warn", e.getClass(), "logPrint(String type, Class<?> t, Object ...message)");
		log.logPrint(e.getClass(), "logPrint(Class<?> t, Object ...message");
		Wrapping.logLog(e);
	}

}
