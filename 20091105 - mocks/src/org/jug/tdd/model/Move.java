package org.jug.tdd.model;

public class Move {

	private CardinalPoint cp;
	private Coordinates coord;
	
	public Move(CardinalPoint _cp, Coordinates _coord){
		this.cp = _cp;
		this.coord = _coord;
	}

	public CardinalPoint getCp() {
		return cp;
	}

	public Coordinates getCoord() {
		return coord;
	}
}
