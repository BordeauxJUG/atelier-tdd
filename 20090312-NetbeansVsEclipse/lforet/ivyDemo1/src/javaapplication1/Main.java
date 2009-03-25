package javaapplication1;

import org.apache.commons.logging.LogFactory;

public class Main {

    public static void main(String[] args) {
        LogFactory.getLog(Main.class).info("Hello world !");
        org.apache.log4j.LogManager.getLogger(Main.class).info("Hello world from log4j");
        
    }

}
