package org.bordeauxjug.tdd.wombat.model;

public interface IActorDelegate {

	String getName();

	Coordinates getCoordinates();

	void act();
	
	void setGreenfootActor(ActorDelegator greenfootActor);
}
