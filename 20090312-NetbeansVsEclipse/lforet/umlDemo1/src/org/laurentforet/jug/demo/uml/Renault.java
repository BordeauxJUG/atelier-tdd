package org.laurentforet.jug.demo.uml;

import java.util.List;

public class Renault implements Marque {

    public List<Modele> getModeles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNom() {
        return "Renault";
    }

  public enum ModelEnum {

        TWINGO, KANGOO, MEGANE;
    }

}
