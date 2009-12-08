package org.bordeauxjug.tdd.wombat.model.impl;

import greenfoot.GreenfootImage;

import org.bordeauxjug.tdd.wombat.greenfoot.ActorDelegator;
import org.bordeauxjug.tdd.wombat.greenfoot.Coordinates;
import org.bordeauxjug.tdd.wombat.greenfoot.IActorDelegate;

public abstract class AbstractActorDelegate implements IActorDelegate{

	protected static final String IMAGES_ROOT_PATH = "C:/Users/Fred/workspaces/JUG/20091109-wombats/images/";
	
	protected static final GreenfootImage GREENFOOT_DEFAULT_IMAGE = new GreenfootImage(IMAGES_ROOT_PATH+"greenfoot.png");
	
	private String name;
	private Coordinates coords;
	private ActorDelegator<? extends IActorDelegate> greenfootActor;
	
	protected AbstractActorDelegate(String _name){
		this(_name, new Coordinates(0, 0));
	}
	
	protected AbstractActorDelegate(String _name, Coordinates _coord){
		this.name = _name;
		this.coords = _coord;
		this.greenfootActor = null;
	}
	
	public String getName(){
		return this.name;
	}

	public Coordinates getCoordinates(){
		return this.coords;
	}

	public void setGreenfootActor(ActorDelegator<? extends IActorDelegate> _greenfootActor){
		this.greenfootActor = _greenfootActor;
	}

	public ActorDelegator<? extends IActorDelegate> getGreenfootActor() {
		return greenfootActor;
	}
	
	@Override
	public GreenfootImage getImage() {
		return GREENFOOT_DEFAULT_IMAGE;
	}
}
