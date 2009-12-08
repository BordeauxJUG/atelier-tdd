package org.bordeauxjug.tdd.wombat.persistence;

import java.sql.SQLException;
import org.h2.tools.Server;

/**
 *
 * @author lfo
 */
public class DBServer {

    private static Server server;
    public final static String SERVER_PORT = "9101";
    private static String serverSettings[] = {"-tcp", "-tcpAllowOthers", "-tcpPort", SERVER_PORT};

    public static void start() throws SQLException {
        server = Server.createTcpServer(serverSettings);
//        server.setOut(System.out);
        server = server.start();
        System.out.println(server.getStatus());
    }

    public static void stop() {
        server.stop();
    }

    public static void main(String... args) throws Exception {
        start();
    }
}
