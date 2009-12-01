package org.bordeauxjug.tdd.wombat.persistence;

import org.bordeauxjug.tdd.wombat.model.Cell;

public interface ITravelerStrategy {
	
	/**
	 * Returns the next cell between currentCell and targetCell
	 * @param currentCell
	 * @param targetCell
	 * @return A cell which is not an obstacle
	 */
	Cell nextCell(Cell currentCell, Cell targetCell);

}
