package org.bordeauxjug.tdd.wombat.persistence;

import org.bordeauxjug.tdd.wombat.model.Cell;
import org.bordeauxjug.tdd.wombat.model.Coordinates;
import org.bordeauxjug.tdd.wombat.model.IActorDelegate;

public interface IWorldDAO {

	void createWorld();
	void registerMoveOn(Cell c, IActorDelegate actor);
	
	/**
	 * @param coord
	 * @param actor May be null
	 * @return La cellule crée
	 */
	Cell createOrUpdateCell(Coordinates coord, IActorDelegate actor);
	
	/**
	 * Will return a cell depending on the actor type : 
	 * - If actor is an
	 * obstacle, Cell will have isObstacle=true 
	 * - If actor is a Prey, Cell will
	 * have prey=instance of a new prey matching the actor's FQN
	 * - If no cell exist at coord, an "empty cell" is returned (isObstacle=false, prey=null etc...)
	 * @param coord
	 * @return
	 */
	Cell getCell(Coordinates coord);
}
