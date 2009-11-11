package org.jug.tdd.model;

public interface IMovable {

	int getSpeed();

	Coordinates move(CardinalPoint direction);

}
