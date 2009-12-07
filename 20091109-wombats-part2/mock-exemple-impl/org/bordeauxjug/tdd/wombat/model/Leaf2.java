package org.bordeauxjug.tdd.wombat.model;

import greenfoot.GreenfootImage;

public class Leaf2 extends AbstractPrey {

	protected static final GreenfootImage LEAF_IMAGE = new GreenfootImage(IMAGES_ROOT_PATH+"leaf.gif");

	public Leaf2(String _name){
		super(_name, Kingdom.VEGETAL);
	}
	
	public Leaf2(String _name, Coordinates _coord){
		super(_name, _coord, Kingdom.VEGETAL);
	}
	
	@Override
	public GreenfootImage getImage() {
		if(isAlive()){
			return LEAF_IMAGE;
		} else {
			return null;
		}
	}
}
