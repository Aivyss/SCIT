package ppulzit;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class LogClass {
	private static Logger log = Logger.getLogger(LogClass.class);

	public LogClass(Class c) {
		Logger log = Logger.getLogger(c);
	}
	
	public static void main(String[] args) {
		log.trace("Trace");
		log.debug("Debug");
		log.info("아 존나 힘들다");
		log.warn("Warn");
		log.error("Error");
		log.fatal("Fatal");
		Exception e = new Exception();
		log.trace(25, e);
		
		//fun("a", 1,2,3,4,5);
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "a");
		
		fun2(hm, 2, "b");
		
		
	}
	
	public static void fun(String str, int ...a) {
		System.out.println(str);
		
		
		for(int aa : a) {
			System.out.println(aa);
		}
	}
	
	public static void fun2(Object... objs) {
		
		for(Object obj : objs) {
			System.out.print(obj+ "\t");
		}
		
	}
	
	public static void fun2(Exception e, Object... objs) {
		
		
	}
	

}
