package org.bordeauxjug.tdd.wombat.persistence;

import org.bordeauxjug.tdd.wombat.model.ActorDelegator;
import org.bordeauxjug.tdd.wombat.model.Coordinates;
import org.bordeauxjug.tdd.wombat.model.IActorDelegate;

public class Obstacle implements IActorDelegate {

	@Override
	public void act() {
	}

	@Override
	public Coordinates getCoordinates() {
		return null;
	}

	@Override
	public String getName() {
		return "Un obstacle";
	}

	@Override
	public void setGreenfootActor(ActorDelegator greenfootActor) {
	}
}
