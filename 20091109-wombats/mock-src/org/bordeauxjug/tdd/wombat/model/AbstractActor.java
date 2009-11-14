package org.bordeauxjug.tdd.wombat.model;

import greenfoot.Actor;

public abstract class AbstractActor extends Actor implements IActor {

	private String name;
	
	protected AbstractActor(String _name){
		this.name = _name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
