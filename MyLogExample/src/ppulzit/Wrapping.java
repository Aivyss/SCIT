package ppulzit;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Wrapping {
	private static Logger log;
	
	
	/**
	 * @param c 동작하는 지점의 클래스명
	 */
	public Wrapping(Class<?> c) {
		log = Logger.getLogger(c);		
	}

	public void logPrint(String type, Object ...message) {
		System.out.println("======LowWarnPrint message 메소드=========");
		for (Object pick : message) {
			System.out.print(pick + "\t");
		}
		System.out.println();
	}
	
	public void logPrint(String type, Throwable t, Object ...message) {
		System.out.println("======LowWarnPrint message, t 메소드=========");
		
		System.out.println("라인번호 : " + t.getStackTrace()[0].getLineNumber());
		
		for (Object pick : message) {
			System.out.print(pick + "\t");
		}
		System.out.println();
		
	}
	
	public void logPrint(String type, Class<?> t, Object ...message) {
		System.out.println("======LowWarnPrint message, Class<?> 메소드=========");
		System.out.println(t.getName()); // 스트링으로 일단 뽑아주넹?
		
		
		if(t.getName().equals("java.lang.ArithmeticException")) {
			System.out.println("일치");
		}
		
		for (Object pick : message) {
			System.out.print(pick + "\t");
		}
		System.out.println();
		
	}
	
	public void logPrint(Class<?> t, Object ...message) {
		System.out.println("======LowWarnPrint message, Class<?> 메소드=========");
		System.out.println(t.getName()); // 스트링으로 일단 뽑아주넹?
		
		String level = returnLevel(t.getName());
		
		System.out.println("에러등급: " + level);
		
		for (Object pick : message) {
			System.out.print(pick + "\t");
		}
		System.out.println();
		
	}
	
	public Logger getLogger() {
		return log;
	}
	
	private String returnLevel(String className) {
		Map<String, String> map = new HashMap<>();
		className = className.substring(10);
		
		map.put("RuntimeException", "fatal");
		map.put("Exception", "fatal");
		map.put("ArithmeticException", "warn");
		map.put("NullPointerException", "debug");
		map.put("IOException", "debug");
		
		String level = "fatal";
		if (map.get(className)!=null) {
			level = map.get(className);
		}
		
		return level;
	}
	
	public static void logLog(Throwable t) {
		if (t.getClass().getName().equals("java.lang.ArithmeticException")) {
			System.out.println(t.getStackTrace()[0].getLineNumber());
			Exception e = new Exception();
			log.fatal("그렇다네요"); // 라인번호를 어떻게 할 수가 없음 =ㅅ=
			log.fatal("실질 라인: "+e.getStackTrace()[1].getLineNumber());
		}
	}
}
