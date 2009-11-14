package org.jug.tdd.model;

public interface IMoveBehaviour {

	int getSpeed();

	Coordinates move(Coordinates currentCoord, CardinalPoint currentDirection);
}
