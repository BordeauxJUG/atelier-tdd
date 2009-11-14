package org.jug.tdd.model;

public interface IMovable {

	void setDirection(CardinalPoint cp);
	void setMoveBehaviour(IMoveBehaviour moveBehaviour);
}
