package org.jug.tdd.model;

public interface IMoveBehaviour {

	boolean canMove(Move currentMove);
	Move move(Move currentMove);
}
