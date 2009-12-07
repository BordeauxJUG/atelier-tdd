package org.bordeauxjug.tdd.wombat.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

/**
 *
 * @author lfo
 */
public class DBPool {

    private final static String JDBC_H2_URL = "jdbc:h2:tcp://localhost:9101/~/.h2/data/wombat";
    private final static String JDBC_H2_USER = "sa";
    private final static String JDBC_H2_PASSWORD = "";

    static JdbcConnectionPool POOL = JdbcConnectionPool.create(JDBC_H2_URL, JDBC_H2_USER, JDBC_H2_PASSWORD);

   
    public static Connection getConnection() throws SQLException {
        return POOL.getConnection();
    }

    public static void dispose() throws SQLException {
        POOL.dispose();
    }

}
