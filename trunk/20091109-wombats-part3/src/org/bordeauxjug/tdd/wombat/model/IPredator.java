package org.bordeauxjug.tdd.wombat.model;

import org.bordeauxjug.tdd.wombat.greenfoot.IActorDelegate;



public interface IPredator extends IActorDelegate, IFoodModable, IMovable {

	void eat(IPrey prey);
	
}
