package org.bordeauxjug.dojo.wombat.processes;

import org.bordeauxjug.dojo.wombat.WombatException;
import org.bordeauxjug.dojo.wombat.World.CardinalPoint;

/**
 *
 * @author laurent.foret
 */
public abstract class PreyProcess {

    public abstract void move(CardinalPoint cp) throws WombatException;

}
