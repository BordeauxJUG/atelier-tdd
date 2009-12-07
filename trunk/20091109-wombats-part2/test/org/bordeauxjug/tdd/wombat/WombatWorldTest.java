package org.bordeauxjug.tdd.wombat;

import greenfoot.World;
import greenfoot.util.GreenfootUtil;

import org.bordeauxjug.tdd.wombat.greenfoot.TestUtilDelegate;
import org.bordeauxjug.tdd.wombat.greenfoot.WorldCreator;
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
		// TODO: add code here ...
	}

}
