package org.bordeauxjug.tdd.wombat.model;

public interface IPrey extends IActor
{
	Kingdom getKingdom();

	int getEnergyValue();

	void gotEaten();
}
