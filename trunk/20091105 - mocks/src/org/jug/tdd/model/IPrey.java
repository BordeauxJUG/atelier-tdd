package org.jug.tdd.model;

public interface IPrey
{
	Kingdom getKingdom();

	int getEnergyValue();

	String getName();

	int getSpeed();

	Coordinates getCoordinates();

	Coordinates move(CardinalPoint direction);

	void gotEaten();
}
