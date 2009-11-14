package org.jug.tdd.model;



public interface IPredator extends IActor {

	void eat(IPrey prey);
	
	boolean canEat(IPrey prey);
	
	void setFoodMode(IFoodMode foodMode);
}
