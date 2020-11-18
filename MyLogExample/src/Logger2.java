
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 내가만든 로그찍는 프로그램
 */
public class Logger2 extends Logger {
	private static Logger2 logger2;
	private static String className;
	private String timeFormat = "yyyy/MM/dd HH:mm:ss";
	Map<String, String> map = new HashMap<String, String>();
	
	protected Logger2(String name) {
		super(name);
		super.repository = Logger.getLogger(name).getLoggerRepository();
		Logger.getLogger(name);
		parent = Logger.getRootLogger();
		className = name;
		levelTable();
	}
	
	public static Logger2 getLogger2(Class<?> clazz) {
		className = clazz.getName();
		logger2 = new Logger2(className);
		return logger2;
	}
	
	public void log (boolean printOnOff, Throwable t, Object ...message) {
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		int line = beforeStack.getLineNumber();
		className = beforeStack.getFileName();
		String methodName = beforeStack.getMethodName();
		String comment = "";
		String level = determineLevel(t);
		String throwablesName = getThrowableName(t);
		
		for (Object obj : message) { // 메세지 합치기
			comment += ("__" + obj.toString());
		}
		comment = comment.substring(2); // 맨앞의 "__" 제거
 
		if (printOnOff) {
			String log = "[" +getCurrentTime() + "]" 
					+ "[" + level + "]" 
					+ "[Class-method name: " + className + "-" + methodName + "]"
					+ "[line: " + line + "]"
					+ "::" 
					+ "[" + throwablesName + "-" + t.getStackTrace()[0].getLineNumber()+"]"
					+ "__" + comment;
			
			System.out.println(log);
		} else {
			comment = "[Class-method name: " + className + "-" + methodName + "]"
					+ "[line: " + line + "]"
					+ "::" 
					+ "[" + throwablesName + "-" + t.getStackTrace()[0].getLineNumber()+"]"
					+ comment;
			
			logging(level, comment);
		}
	}
	
	public void log (boolean printOnOff, String level, Throwable t, Object ...message) {
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		int line = beforeStack.getLineNumber();
		className = beforeStack.getFileName();
		String methodName = beforeStack.getMethodName();
		String comment = "";
		String throwablesName = getThrowableName(t);
		
		for (Object obj : message) { // 메세지 합치기
			comment += ("__" + obj.toString());
		}
		comment = comment.substring(2); // 맨앞의 "__" 제거
 
		if (printOnOff) {
			String log = "[" +getCurrentTime() + "]" 
					+ "[" + level.toUpperCase() + "]" 
					+ "[Class-method name: " + className + "-" + methodName + "]"
					+ "[line: " + line + "]"
					+ "::" 
					+ "[" + throwablesName + "-" + t.getStackTrace()[0].getLineNumber()+"]"
					+ "__" + comment;
			
			System.out.println(log);
		} else {
			comment = "[Class-method name: " + className + "-" + methodName + "]"
					+ "[line: " + line + "]"
					+ "::" 
					+ "[" + throwablesName + "-" + t.getStackTrace()[0].getLineNumber()+"]"
					+ comment;
			
			logging(level, comment);
		}
	}
	
	public void log (boolean printOnOff, String level, Object ...message) {
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		String methodName = beforeStack.getMethodName();
		int line = beforeStack.getLineNumber();
		String comment = "";
		
		for (Object obj : message) { // 메세지 합치기
			comment += ("__" + obj.toString());
		}
		comment = comment.substring(2); // 맨앞의 "__" 제거
		
		if (printOnOff) {
			String log = "[" +getCurrentTime() + "]" 
						+ "[" + level.toUpperCase() + "]" 
						+ "[Class-method name: " + className + "-" + methodName + "]"
						+ "[line: " + line + "]" 
						+ "::" 
						+ comment;
			
			System.out.println(log);
		} else {
			comment = "[Class name: " + className + "-" + methodName + "]" 
					+ "[line: " + line + "]" 
					+ "::" 
					+ comment;
			
			logging(level, comment);
		}
	}
	
	private String determineLevel(Throwable t) { // 작성완료
		String throwablesName = getThrowableName(t);
		String resultLevel = map.get(throwablesName).toUpperCase();
		
		if(level == null) {
			resultLevel = "FATAL";
		}
		
		return resultLevel;
	}
	
	private String getThrowableName(Throwable t) {
		String throwablesName = t.getClass().getName();
		String[] temparry = throwablesName.split("");
		for (String str : temparry) {
			if(str.equals(".")) {
				throwablesName = "";
				continue;
			}
			
			throwablesName += str;
		}
		
		return throwablesName;
	}
	
	private void logging(String level, String comment) {
		if (level.equalsIgnoreCase("fatal")) {
			super.fatal(comment);
		} else if (level.equalsIgnoreCase("error")) {
			super.error(comment);
		} else if (level.equalsIgnoreCase("warn")) {
			super.warn(comment);
		} else if (level.equalsIgnoreCase("info")) {
			super.info(comment);
		} else if (level.equalsIgnoreCase("debug")) {
			super.debug(comment);
		} else if (level.equalsIgnoreCase("trace")) {
			super.trace(comment);
		}
	}
	
	private String getCurrentTime() { // 작성완료
		return new SimpleDateFormat(timeFormat).format(System.currentTimeMillis());
	}
	
	private void levelTable() { // 주기적으로 업뎃
		String fatal = "fatal";
		String error = "error";
		String warn = "warn";
		String info = "info";
		String debug = "debug";
		String trace = "trace";
		
		map.put("Exception", fatal);
		map.put("IllegalArgumentException", fatal);
		map.put("RuntimeException", fatal);
		map.put("SystemException", fatal);
		map.put("ClassNotFoundException", warn);
		map.put("ClassCastExcetion", warn);
		map.put("NullPointException", debug);
		map.put("ArrayIndexOutOfBoundsException", debug);
		map.put("IOException", debug);
		map.put("IndexOutOfBoundException", debug);
		map.put("ArithmeticException", debug);
		map.put("FileNotFoundException", info);
		map.put("InputMismatchException", trace);
	}
	
}
