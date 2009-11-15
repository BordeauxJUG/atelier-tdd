package org.bordeauxjug.tdd.wombat.model;

import greenfoot.World;
import greenfoot.core.WorldHandler;

public class StraightLineMoveBehaviour implements IMoveBehaviour {

	@Override
	public Move move(Move currentMove) {
		Move newMove = new Move(currentMove.getCp(), new Coordinates(currentMove.getCoord().x, currentMove.getCoord().y));
		if (canMove(currentMove)) {
			switch (currentMove.getCp())
			{
				case SOUTH :
					newMove.getCoord().y++;
					break;
				case EAST :
					newMove.getCoord().x++;
					break;
				case NORTH :
					newMove.getCoord().y--;
					break;
				case WEST :
					newMove.getCoord().x--;
					break;
			}
		} else {
			turnLeft(currentMove, newMove);
		}
		return newMove;
	}

	/**
	 * Test if we can move forward. Return true if we can, false otherwise.
	 */
	public boolean canMove(Move currentMove)
	{
		World myWorld = WorldHandler.getInstance().getWorld();
		int x = currentMove.getCoord().x;
		int y = currentMove.getCoord().y;
		switch (currentMove.getCp()) {
			case SOUTH : y++; break;
			case EAST : x++; break;
			case NORTH : y--; break;
			case WEST : x--; break;
		}
		
		// test for outside border
		if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
			return false;
		} else if (x < 0 || y < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Turns towards the left.
	 */
	public void turnLeft(Move currentMove, Move newMove) {
		switch (currentMove.getCp()) {
			case SOUTH : newMove.setCp(CardinalPoint.EAST); break;
			case EAST : newMove.setCp(CardinalPoint.NORTH); break;
			case NORTH : newMove.setCp(CardinalPoint.WEST); break;
			case WEST : newMove.setCp(CardinalPoint.SOUTH); break;
		}
	}
}
