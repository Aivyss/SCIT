package de.laliluna.logexample;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;

public class LogClass {
    private static org.apache.log4j.Logger log = Logger
	    .getLogger(LogClass.class);
public void getI(){};
    public static void main(String[] args) {

	// use the loader helper from log4j
	// URL url = Loader.getResource("my.properties");
	// PropertyConfigurator.configure(url);

	// use the same class loader as your class
	// URL url = LogClass.class.getResource("/my.properties");
	// PropertyConfigurator.configure(url);

	// load custom XML configuration
	// URL url = Loader.getResource("my.xml");
	// DOMConfigurator.configure(url);
	
	log.trace("Trace");
	log.debug("Debug");
	log.info("Info");
	DOMConfigurator.configure(Loader.getResource("my.xml"));
	log.warn("Warn");
	log.error("Error");
	log.fatal("Fatal");

	try {
	    LogClass class1 = null;
	    class1.getI();
	    
	} catch (RuntimeException e) {
	    try {
		throw new RuntimeException("My Exception name", e);
		
	    } catch (RuntimeException e1) {
		log.error(e1, e1);
	    }

	    
	}

    }
}