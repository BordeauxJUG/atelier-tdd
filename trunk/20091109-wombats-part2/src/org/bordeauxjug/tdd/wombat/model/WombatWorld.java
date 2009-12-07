package org.bordeauxjug.tdd.wombat.model;

import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * A world where wombats live.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
	
	/**
	 * Create a new world with 8x8 cells and with a cell size of 60x60 pixels
	 * and with populated objects
	 */
	public WombatWorld(){
		this(8,8,true);
	}
	
	/**
	 * Create a new world with worldWidth x worldHeight cells and with a cell size of 60x60 pixels
	 * World population depends on populate flag
	 * @param worldWidth Number of x cells
	 * @param worldHeight Number of y cells
	 * @param populate If true, will populate world with wombats and leaves, otherwise, world will be
	 * freed
	 */
	public WombatWorld(int worldWidth, int worldHeight, boolean populate){
		super(worldWidth, worldHeight, 60);
		setBackground("images/cell.jpg");
		if(populate){
			populate();
		}
	}

	// @Test
	public void test()
	{
		System.out.println("Hello");
	}

	/**
	 * 
	 * Populate the world with a fixed scenario of wombats and leaves.
	 */
	public void populate()
	{
		addObject(new Wombat2("w1"), 0, 0);
		addObject(new Wombat2("w2"), 1, 7);
		randomLeaves(8);
	}

	/**
	 * Allows to add an ActorDelegate object to the scene
	 */
	public void addObject(IActorDelegate actorDelegate, int x, int y){
		// Setting actor's coords
		actorDelegate.getCoordinates().x = x;
		actorDelegate.getCoordinates().y = y;
		
		// Creating & adding ActorDelegator on the previous ActorDelegate
		ActorDelegator<IActorDelegate> d = new ActorDelegator<IActorDelegate>(actorDelegate);
		actorDelegate.setGreenfootActor(d);
		addObject(d, x, y);
	}
	
	/**
	 * Place a number of leaves into the world at random places. The number of
	 * leaves can be specified.
	 */
	public void randomLeaves(int howMany)
	{
		for (int i = 0; i < howMany; i++)
		{
			Leaf2 leaf = new Leaf2("l"+i);
			int x = Greenfoot.getRandomNumber(getWidth());
			int y = Greenfoot.getRandomNumber(getHeight());
			addObject(leaf, x, y);
		}
	}
}