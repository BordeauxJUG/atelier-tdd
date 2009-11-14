package org.jug.tdd.model;



public interface IPredator extends IActor, ISensorable, IFoodModable {

	void eat(IPrey prey);
	
}
