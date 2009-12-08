package org.bordeauxjug.tdd.wombat.helper;

import greenfoot.Actor;
import greenfoot.World;
import greenfoot.WorldVisitor;
import greenfoot.core.ActInterruptedException;
import greenfoot.core.WorldHandler;
import greenfoot.util.GreenfootUtil;

import java.util.ArrayList;
import java.util.List;

import org.bordeauxjug.tdd.wombat.greenfoot.TestUtilDelegate;
import org.bordeauxjug.tdd.wombat.model.WombatWorld;

/**
 * Classe qui devrait venir remplacer la classe WorldCreator
 * @author Frederic Camblor
 */
public class WorldTestHelper {

	public static World initializeWorld(int worldWidth, int worldHeight, boolean populate){
		GreenfootUtil.initialise(new TestUtilDelegate());
		World world = new WombatWorld(worldWidth, worldHeight, populate);
		WorldHandler.initialise();
		WorldHandler.getInstance().setWorld(world);
		return world;
	}
	
	public static void runOneLoop(){
		World myWorld = WorldHandler.getInstance().getWorld();
        List<Actor> objects = new ArrayList<Actor>(WorldVisitor.getObjectsListInActOrder(myWorld));
        for (Actor actor : objects) {
            if (actor.getWorld() != null) {
                try {
                    actor.act();
                }
                catch (ActInterruptedException e) {
                }
            }

        }
	}
}
