package org.bordeauxjug.hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bordeauxjug.services.HelloWorldService;

/**
 * This application say "Hello World !" using the {@link org.apache.commons.logging.Log} class.
 *
 * @since 1.0
 * @author lfo
 */
public class App {

    private static Log commonsLogger = LogFactory.getLog(App.class);

    /**
     * Main method very usefull to launch the HelloWorld application.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        commonsLogger.debug("Entering main() ...");
        new HelloWorldService().sayHello();

    }
}
