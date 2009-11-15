package org.bordeauxjug.tdd.wombat.model;

import greenfoot.Actor;

public class ActorDelegator<T extends IActorDelegate> extends Actor {

	private T actorDelegate;
	
	public ActorDelegator(T _delegate){
		super();
		this.actorDelegate = _delegate;
		this.actorDelegate.setGreenfootActor(this);
	}
	
	@Override
	public void act() {
		super.act();
		
		// delegates to the IActor
		this.actorDelegate.act();
	}
	
	public T getActorDelegate(){
		return this.actorDelegate;
	}
}
