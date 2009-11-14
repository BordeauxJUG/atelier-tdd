package org.jug.tdd.model;

public interface IMoveBehaviour {

	boolean canMove(Coordinates currentCoord, CardinalPoint currentDirection);
	Coordinates move(Coordinates currentCoord, CardinalPoint currentDirection);
}
