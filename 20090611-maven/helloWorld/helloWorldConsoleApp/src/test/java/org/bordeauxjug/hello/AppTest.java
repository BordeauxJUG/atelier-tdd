package org.bordeauxjug.hello;

import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * The test for the application launching.
 * 
 * @author lfo
 */
public class AppTest extends TestCase {

    private static Log commonsLogger = LogFactory.getLog(AppTest.class);


    /**
     * Simple Test
     */
    public void testApp() {
        commonsLogger.debug("testApp is called !");
        App.main(new String[]{});
        commonsLogger.debug("testApp is finished !");
    }
}
