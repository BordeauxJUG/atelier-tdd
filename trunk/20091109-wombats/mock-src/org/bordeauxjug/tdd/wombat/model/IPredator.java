package org.bordeauxjug.tdd.wombat.model;



public interface IPredator extends IActorDelegate, IFoodModable, IMovable {

	void eat(IPrey prey);
	
}
