package org.laurentforet.jug.demo.profiler;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeaker {

    private static Map<String, byte[]> logs = new HashMap<String, byte[]>();

    public static void main(String[] args) {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
            Thread t = new Thread(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                    }

                    System.err.println(this.toString() + " - Launched");
                    logs.put(this.toString(), generateMessage() );
                    
                }
            });

            t.start();
        }
    }












    















    

    private static byte[] generateMessage() {
        return new byte[100000];
    }

}
