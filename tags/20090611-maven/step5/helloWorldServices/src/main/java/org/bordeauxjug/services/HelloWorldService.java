package org.bordeauxjug.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorldService {

    private static Log log = LogFactory.getLog(HelloWorldService.class);

    public void sayHello() {
        log.info("Hello World !");
    }


}
