package org.bordeauxjug.tdd.wombat.model;

public class Cell {

    private Coordinates coordinates;
    private IPrey prey;
    private int quantity;
    private int timesWombatHasBeenHere;
    private boolean isObstacle;

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

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}

	public int getTimesWombatHasBeenHere() {
		return timesWombatHasBeenHere;
	}

	public void setTimesWombatHasBeenHere(int timesWombatHasBeenHere) {
		this.timesWombatHasBeenHere = timesWombatHasBeenHere;
	}

}
