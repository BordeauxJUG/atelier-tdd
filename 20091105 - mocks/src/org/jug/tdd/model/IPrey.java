package org.jug.tdd.model;

public interface IPrey extends IMovable, IActor
{
	Kingdom getKingdom();

	int getEnergyValue();

	void gotEaten();
}
