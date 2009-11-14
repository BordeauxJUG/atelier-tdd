package org.jug.tdd.model;

public interface IPrey extends IActor
{
	Kingdom getKingdom();

	int getEnergyValue();

	void gotEaten();
}
