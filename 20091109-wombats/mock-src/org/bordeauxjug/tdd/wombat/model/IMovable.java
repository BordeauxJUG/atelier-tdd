package org.bordeauxjug.tdd.wombat.model;

public interface IMovable<T extends IMoveBehaviour> {

	void setDirection(CardinalPoint cp);
	void setMoveBehaviour(T moveBehaviour);
}
