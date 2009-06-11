package org.bordeauxjug.hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class App {

    private static Log commonsLogger = LogFactory.getLog(App.class);

    public static void main(String[] args) {
//        commonsLogger.debug("Entering main() ...");
        commonsLogger.info("Hello World!");

    }
}
