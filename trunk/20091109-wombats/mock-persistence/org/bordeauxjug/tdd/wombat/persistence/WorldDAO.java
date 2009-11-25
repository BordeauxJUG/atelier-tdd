package org.bordeauxjug.tdd.wombat.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.bordeauxjug.tdd.wombat.model.Cell;

/**
 *
 * @author laurent.foret
 */
public class WorldDAO {

    public static String CREATE_CELL_TABLE =
            "create table \"PUBLIC\".CELL ("
            + "ID int primary key, "
            + "COORD_X INT not null, "
            + "COORD_Y INT not null, "
            + "PREY_FK int, "
            + "WOMBAT_HAS_BEEN_HERE boolean, "
            + "QUANTITY int)";
    public static String DROP_CELL_TABLE =
            "drop table \"PUBLIC\".CELL";

    public void update(Cell cell) throws SQLException {
    }

    public void create(Cell cell) throws SQLException {
    }

    public void createSchema() throws SQLException {
        executeBatch(new String[]{DROP_CELL_TABLE, CREATE_CELL_TABLE});

    }

    private void executeBatch(String[] args) throws SQLException {
        Statement stmt = null;

        try {
            Connection connection = DBPool.getConnection();
            stmt = connection.createStatement();
            for (String arg : args) {
                stmt.addBatch(arg);
            }
            stmt.executeBatch();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
