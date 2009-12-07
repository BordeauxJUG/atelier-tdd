package org.bordeauxjug.tdd.wombat.model;

public class UniqueFoodMode implements IFoodMode {

	private Kingdom allowedKingdom;
	
	public UniqueFoodMode(Kingdom _allowedKingdom){
		this.allowedKingdom = _allowedKingdom;
	}
	
	
	@Override
	public boolean canEat(IPrey prey) {
		return prey.isAlive() && prey.getKingdom() == this.allowedKingdom;
	}

}
