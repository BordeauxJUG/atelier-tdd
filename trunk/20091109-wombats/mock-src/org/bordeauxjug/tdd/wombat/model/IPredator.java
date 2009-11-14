package org.bordeauxjug.tdd.wombat.model;



public interface IPredator extends IActor, IFoodModable, IMovable {

	void eat(IPrey prey);
	
}
