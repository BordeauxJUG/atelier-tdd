package org.jug.tdd.model;

public interface IPrey extends IMovable
{
	Kingdom getKingdom();

	int getEnergyValue();

	String getName();

	Coordinates getCoordinates();

	void gotEaten();
}
