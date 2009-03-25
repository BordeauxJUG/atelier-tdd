package org.laurentforet.jug.demo.uml;

import java.util.List;

public class Peugeot implements Marque {

    public String getNom() {
        return "Peugeot";
    }

    public List<Modele> getModeles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public enum ModelEnum {

        P107, P207, P307;
    }
}
