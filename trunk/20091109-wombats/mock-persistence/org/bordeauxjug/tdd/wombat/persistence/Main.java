package org.bordeauxjug.tdd.wombat.persistence;

public class Main {

    public static void main(String[] args) throws Exception {
        WorldDAO dao = new WorldDAO();
        dao.createSchema();
    }

}
