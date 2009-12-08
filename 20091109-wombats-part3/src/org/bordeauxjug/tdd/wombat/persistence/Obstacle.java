package org.bordeauxjug.tdd.wombat.persistence;

import greenfoot.GreenfootImage;

import org.bordeauxjug.tdd.wombat.model.impl.AbstractActorDelegate;

public class Obstacle extends AbstractActorDelegate {

	protected static final GreenfootImage OBSTACLE_IMAGE = new GreenfootImage(IMAGES_ROOT_PATH+"rock.gif");

	public Obstacle(String _name){
		super(_name);
	}
	
	@Override
	public void act() {
	}
	
	@Override
	public GreenfootImage getImage() {
		return OBSTACLE_IMAGE;
	}
}
