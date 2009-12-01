package org.bordeauxjug.tdd.wombat.greenfoot;

import greenfoot.Actor;
import greenfoot.World;
import greenfoot.WorldVisitor;
import greenfoot.core.ActInterruptedException;
import greenfoot.core.WorldHandler;
import greenfoot.util.GreenfootUtil;

import java.util.ArrayList;
import java.util.List;

import org.bordeauxjug.tdd.wombat.model.WombatWorld;
import org.bordeauxjug.tdd.wombat.persistence.IWorldDAO;

/**
 * Classe qui devrait venir remplacer la classe WorldCreator
 * @author Frederic Camblor
 */
public class WorldHelper {

	public static void initializeWorld(int worldWidth, int worldHeight, IWorldDAO worldDAO){
		GreenfootUtil.initialise(new TestUtilDelegate());
		World world = new WombatWorld(worldWidth, worldHeight, false, worldDAO);
		WorldHandler.initialise();
		WorldHandler.getInstance().setWorld(world);
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
