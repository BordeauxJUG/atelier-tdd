package org.bordeauxjug.tdd.wombat.model;

public interface IMovable {

	void setDirection(CardinalPoint cp);
	void setMoveBehaviour(IMoveBehaviour moveBehaviour);
}
