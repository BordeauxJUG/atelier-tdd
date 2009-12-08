package org.bordeauxjug.tdd.wombat;

import greenfoot.World;

import org.bordeauxjug.tdd.wombat.helper.WorldTestHelper;
import org.junit.BeforeClass;
import org.junit.Test;

public class WombatWorldTest
{
	private World world;


	@BeforeClass
	public void setUp() throws Exception
	{
		world = WorldTestHelper.initializeWorld(8, 8, false);
	}

	@Test
	public void testMove()
	{
		// TODO: add code here ...
	}

}
