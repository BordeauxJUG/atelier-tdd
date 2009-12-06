package org.bordeauxjug.tdd.wombat.persistence;

import org.bordeauxjug.tdd.wombat.model.Cell;
import org.bordeauxjug.tdd.wombat.model.Coordinates;
import org.bordeauxjug.tdd.wombat.model.IActorDelegate;
import org.bordeauxjug.tdd.wombat.model.Wombat2;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            IWorldDAO dao = new WorldDAO();
            dao.createWorld();
            Coordinates coord11 = new Coordinates(1, 1);
            Coordinates coord12 = new Coordinates(1, 2);
            Coordinates coord21 = new Coordinates(2, 1);
            Coordinates coord22 = new Coordinates(2, 2);

            dao.createOrUpdateCell(coord11, new Obstacle("o1"));
            dao.createOrUpdateCell(coord22, null);

            Cell cell12 = dao.getCell(coord12);
            Cell cell21 = dao.getCell(coord21);
            
            IActorDelegate albert = new Wombat2("Albert");
            dao.registerMoveOn(cell21, albert);
            dao.registerMoveOn(cell12, albert);
            dao.registerMoveOn(cell21, albert);
            Cell cell11 = dao.getCell(coord11);
            
            try {
                dao.registerMoveOn(cell11, albert);
            } catch (RuntimeException ex) {
                System.err.println(ex.getMessage());
            }
        } finally {
//            DBServer.stop();
    }
    }

}
