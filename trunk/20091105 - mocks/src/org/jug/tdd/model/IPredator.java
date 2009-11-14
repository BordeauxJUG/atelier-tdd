package org.jug.tdd.model;



public interface IPredator extends IActor, ISensorable, IFoodModable, IMovable {

	void eat(IPrey prey);
	
}
