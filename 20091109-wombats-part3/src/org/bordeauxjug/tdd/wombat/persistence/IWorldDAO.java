package org.bordeauxjug.tdd.wombat.persistence;

import java.sql.SQLException;

import org.bordeauxjug.tdd.wombat.greenfoot.Coordinates;
import org.bordeauxjug.tdd.wombat.greenfoot.IActorDelegate;

public interface IWorldDAO {

	void createWorld() throws SQLException;
	void registerMoveOn(Cell c, IActorDelegate actor) throws SQLException;
	
	/**
	 * @param coord
	 * @param actor May be null
	 * @return La cellule cr�e
	 */
	Cell createOrUpdateCell(Coordinates coord, IActorDelegate actor) throws SQLException;
	
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
	Cell getCell(Coordinates coord) throws SQLException;
}
