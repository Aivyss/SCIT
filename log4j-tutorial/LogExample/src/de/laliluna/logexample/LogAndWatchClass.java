package de.laliluna.logexample;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.xml.DOMConfigurator;

public class LogAndWatchClass {
    private static org.apache.log4j.Logger log;

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
	DOMConfigurator.configureAndWatch("/log4j.xml", 2000);
	
	log = Logger.getLogger(LogAndWatchClass.class);
	for (int i = 0; i < 5; i++) {
	    log.trace("Trace");
	    log.debug("Debug");
	    log.info("Info");

	    log.warn("Warn");
	    log.error("Error");
	    log.fatal("Fatal");
	    try {
		Thread.currentThread().sleep(4000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	try {
	    LogAndWatchClass class1 = null;

	} catch (RuntimeException e) {
	    try {
		throw new RuntimeException("My Exception name", e);

	    } catch (RuntimeException e1) {
		log.error(e1, e1);
	    }

	}

    }
}