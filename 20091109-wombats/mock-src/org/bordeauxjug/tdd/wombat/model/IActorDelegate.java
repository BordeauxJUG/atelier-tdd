package org.bordeauxjug.tdd.wombat.model;

import greenfoot.GreenfootImage;

public interface IActorDelegate {

	String getName();

	Coordinates getCoordinates();

	void act();
	
	void setGreenfootActor(ActorDelegator<? extends IActorDelegate> greenfootActor);
	
	GreenfootImage getImage();
}
