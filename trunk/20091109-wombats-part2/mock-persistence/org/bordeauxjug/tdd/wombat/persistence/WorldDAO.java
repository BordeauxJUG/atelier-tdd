package org.bordeauxjug.tdd.wombat.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bordeauxjug.tdd.wombat.model.Cell;
import org.bordeauxjug.tdd.wombat.model.Coordinates;
import org.bordeauxjug.tdd.wombat.model.IActorDelegate;
import org.bordeauxjug.tdd.wombat.model.IPredator;
import org.bordeauxjug.tdd.wombat.model.IPrey;

/**
 *
 * @author laurent.foret
 */
public class WorldDAO implements IWorldDAO {

    public final static String CREATE_CELL_TABLE =
            "CREATE TABLE IF NOT EXISTS CELL (" +
            "  COORD_X INT NOT NULL ," +
            "  COORD_Y INT NOT NULL ," +
            "  IS_OBSTACLE BOOLEAN NULL ," +
            "  TIMES_WOMBAT_HAS_BEEN_HERE INT NULL ," +
            "  PREY_DESCR VARCHAR(255) ," +
            "  PRIMARY KEY (COORD_X, COORD_Y) )";
    public final static String DROP_CELL_TABLE = "DROP TABLE IF EXISTS CELL";
    public final static String INSERT_IN_CELL = "INSERT INTO CELL " +
            "(COORD_X, COORD_Y, IS_OBSTACLE,  TIMES_WOMBAT_HAS_BEEN_HERE) " +
            "VALUES ( ?, ?, ?, ?);";
    public final static String SELECT_CELL = "SELECT * FROM CELL " +
            "WHERE COORD_X = ? " +
            "AND COORD_Y =?";
    public final static String UPDATE_CELL = "UPDATE CELL " +
            "SET IS_OBSTACLE = ?, " +
            "TIMES_WOMBAT_HAS_BEEN_HERE = ?, " +
            "PREY_DESCR = ? " +
            "WHERE COORD_X = ? " +
            "AND COORD_Y =?";

    @Override
    public void createWorld() throws SQLException {
        executeBatch(new String[]{DROP_CELL_TABLE, CREATE_CELL_TABLE});
    }

    @Override
    public Cell getCell(Coordinates coord) throws SQLException {
        Cell cell = selectCell(coord);
        return (cell != null) ? cell : createDefaultCell(coord);
    }

    @Override
    public void registerMoveOn(Cell c, IActorDelegate actor) throws SQLException {
        if (c.isObstacle()) {
            throw new RuntimeException("impossible move");
        }
        createOrUpdateCell(c.getCoordinates(), actor);
    }

    @Override
    public Cell createOrUpdateCell(Coordinates coord, IActorDelegate actor) throws SQLException {
        Cell cell = selectCell(coord);
        boolean newCell = (cell == null);
        if (newCell) {
            cell = createDefaultCell(coord);
    }
        boolean isObstacle = (actor instanceof Obstacle);
        if (isObstacle) {
            cell.setObstacle(isObstacle);
        }
        if (actor instanceof IPrey) {
            cell.setPrey((IPrey) actor);
        }
        if (actor instanceof IPredator) {
            cell.setTimesWombatHasBeenHere(cell.getTimesWombatHasBeenHere() + 1);
        }
        if (newCell) {
            insertCell(cell);
        } else {
            updateCell(cell);
        }
        return cell;
    }

    private Cell selectCell(Coordinates coord) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connection connection = DBPool.getConnection();
            stmt = connection.prepareStatement(SELECT_CELL);
            stmt.setInt(1, coord.getX());
            stmt.setInt(2, coord.getY());
            rs = stmt.executeQuery();
            Cell cell = null;
            if (rs.next()) {
                cell = new Cell(coord, rs.getBoolean(3), rs.getInt(4));
            }
            return cell;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    private void insertCell(Cell cell) throws SQLException {
        Connection connection = DBPool.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(INSERT_IN_CELL);
            stmt.setInt(1, cell.getCoordinates().getX());
            stmt.setInt(2, cell.getCoordinates().getY());
            stmt.setBoolean(3, cell.isObstacle());
            stmt.setInt(4, cell.getTimesWombatHasBeenHere());
            if (cell.getPrey() != null) {
                stmt.setString(5, cell.getPrey().toString());
            }
            stmt.execute();
            connection.commit();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            connection.close();
        }
    }
		
    private void updateCell(Cell cell) throws SQLException {
        Connection connection = DBPool.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(UPDATE_CELL);
            stmt.setBoolean(1, cell.isObstacle());
            stmt.setInt(2, cell.getTimesWombatHasBeenHere());
            stmt.setString(3, (cell.getPrey() != null) ? cell.getPrey().toString() : null);
            stmt.setInt(4, cell.getCoordinates().getX());
            stmt.setInt(5, cell.getCoordinates().getY());
            stmt.execute();
            connection.commit();
        } finally {
            if (stmt != null) {
                stmt.close();
	}
            connection.close();
        }
    }

    private void executeBatch(String[] args) throws SQLException {
        Statement stmt = null;
        Connection connection = DBPool.getConnection();
        try {
            stmt = connection.createStatement();
            for (String arg : args) {
                stmt.addBatch(arg);
	}
            stmt.executeBatch();
            connection.commit();

        } finally {
            if (stmt != null) {
                stmt.close();
	}
            connection.close();
        }
    }

    private Cell createDefaultCell(Coordinates coord) {
        return new Cell(coord, false, 0);
	}
}
