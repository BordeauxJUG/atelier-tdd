package org.bordeauxjug.tdd.wombat.model;

public interface IPrey extends IActorDelegate
{
	Kingdom getKingdom();

	int getEnergyValue();

	void gotEaten();
	
	boolean isAlive();
}
