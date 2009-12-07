package org.bordeauxjug.tdd.wombat.model;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.sql.SQLException;

import org.bordeauxjug.tdd.wombat.persistence.IWorldDAO;
import org.bordeauxjug.tdd.wombat.persistence.Obstacle;
import org.bordeauxjug.tdd.wombat.persistence.WorldDAO;

/**
 * A world where wombats live.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class WombatWorld extends World
{
	
	private IWorldDAO worldDAO;
	
	/**
	 * Create a new world with 8x8 cells and with a cell size of 60x60 pixels
	 * and with populated objects
	 */
	public WombatWorld(){
		this(8,8,true, new WorldDAO());
	}
	
	/**
	 * Create a new world with worldWidth x worldHeight cells and with a cell size of 60x60 pixels
	 * World population depends on populate flag
	 * @param worldWidth Number of x cells
	 * @param worldHeight Number of y cells
	 * @param populate If true, will populate world with wombats and leaves, otherwise, world will be
	 * freed
	 */
	public WombatWorld(int worldWidth, int worldHeight, boolean populate, IWorldDAO dao){
		super(worldWidth, worldHeight, 60);
		this.worldDAO = dao;
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
		addObject(new Leaf2("l1"), 5, 3);
		addObject(new Leaf2("l2"), 0, 2);
		addObject(new Leaf2("l3"), 7, 5);
		addObject(new Leaf2("l4"), 2, 6);
		addObject(new Leaf2("l5"), 5, 0);
		addObject(new Leaf2("l6"), 4, 7);
		addObject(new Obstacle("o1"), 4, 6);
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
	
	@Override
	public synchronized void addObject(Actor actor, int x, int y) {
        try {
    		super.addObject(actor, x, y);
    		worldDAO.createOrUpdateCell(
    				new Coordinates(x, y),
    				((ActorDelegator<IActorDelegate>) actor).getActorDelegate());
        } catch (SQLException ex) {
            new RuntimeException(ex);
        }
	}

	/**
	 * Place a number of leaves into the world at random places. The number of
	 * leaves can be specified.
	 */
	public void randomLeaves(int howMany)
	{
		for (int i = 0; i < howMany; i++)
		{
			Leaf leaf = new Leaf();
			int x = Greenfoot.getRandomNumber(getWidth());
			int y = Greenfoot.getRandomNumber(getHeight());
			addObject(leaf, x, y);
		}
	}
}