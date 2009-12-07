package org.bordeauxjug.tdd.wombat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import greenfoot.World;
import greenfoot.util.GreenfootUtil;

import org.bordeauxjug.tdd.wombat.greenfoot.TestUtilDelegate;
import org.bordeauxjug.tdd.wombat.greenfoot.WorldCreator;
import org.bordeauxjug.tdd.wombat.model.Leaf;
import org.bordeauxjug.tdd.wombat.model.Wombat;
import org.junit.BeforeClass;
import org.junit.Test;

public class WombatWorldTest
{
	private World world;


	@BeforeClass
	public static void setUp() throws Exception
	{
		GreenfootUtil.initialise(new TestUtilDelegate());
	}

	@Test
	public void testMove()
	{
		world = WorldCreator.createWorld();
		Wombat w = new Wombat();
		world.addObject(w, 2, 2);
		w.move();

		assertEquals(3, w.getX());
		assertEquals(2, w.getY());

	}

	@Test
	public void testWombatEatsLeaves()
	{
		world = WorldCreator.createWorld();
		Wombat w = new Wombat();
		world.addObject(w, 2, 2);
		Leaf l = new Leaf();
		world.addObject(l, 3, 2);
		w.act();
		w.act();
		// Remove call to populate() method in the default constructor of
		// WombatWorld to have this test pass
		assertTrue("Il existe encore des feuilles", world.getObjects(Leaf.class).isEmpty());
	}

}
