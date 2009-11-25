package org.bordeauxjug.tdd.wombat.model;

public class Cell {

    private Coordinates coordinates;
    private IPrey prey;
    private int quantity;
    private boolean wombatHasBeenHere;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public IPrey getPrey() {
        return prey;
    }

    public void setPrey(IPrey prey) {
        this.prey = prey;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isWombatHasBeenHere() {
        return wombatHasBeenHere;
    }

    public void setWombatHasBeenHere(boolean wombatHasBeenHere) {
        this.wombatHasBeenHere = wombatHasBeenHere;
    }
    
}
