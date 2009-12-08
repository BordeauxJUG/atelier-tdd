package org.bordeauxjug.tdd.wombat.model;

import org.bordeauxjug.tdd.wombat.greenfoot.IActorDelegate;

public interface IPrey extends IActorDelegate {
	Kingdom getKingdom();

	int getEnergyValue();

	void gotEaten();
	
	boolean isAlive();
}
