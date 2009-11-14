package org.jug.tdd.model;



public interface IPredator extends IActor, IFoodModable, IMovable {

	void eat(IPrey prey);
	
}
