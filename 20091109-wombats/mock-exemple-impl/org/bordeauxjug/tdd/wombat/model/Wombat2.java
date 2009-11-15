package org.bordeauxjug.tdd.wombat.model;

import java.util.Iterator;
import java.util.List;

import greenfoot.World;
import greenfoot.core.WorldHandler;


public class Wombat2 implements IPredator {

	private String name;
	private IMoveBehaviour moveBehaviour;
	private IFoodMode foodMode;
	private Move currentMove;
	private ActorDelegator greenfootActor;
	
	public Wombat2(String _name, Move _currentMove, IMoveBehaviour _moveBehaviour, IFoodMode _foodMode){
		super();
		this.name = _name;
		this.moveBehaviour = _moveBehaviour;
		this.foodMode = _foodMode;
		this.currentMove = _currentMove;
		this.greenfootActor = null;
		//currentMoveUpdated();
	}
	
	@Override
	public void act() {
		// Let's see if we can eat outta here ...
		World myWorld = WorldHandler.getInstance().getWorld();
		List<ActorDelegator> actors = myWorld.getObjectsAt(currentMove.getCoord().x, currentMove.getCoord().y, ActorDelegator.class);
		
		boolean somethingEaten = false;
		Iterator<ActorDelegator> actorsIter = actors.iterator();
		while(actorsIter.hasNext() && !somethingEaten){
			ActorDelegator actor = actorsIter.next();
			if(actor.getActorDelegate() instanceof IPrey){
				IPrey prey = (IPrey)actor.getActorDelegate();
				if(foodMode.canEat(prey)){
					eat(prey);
					somethingEaten = true;
				}
			}
		}
		
		if(!somethingEaten){
			// Nothing to eat ... let's move !
			Move newMove = moveBehaviour.move(currentMove);
			
			// If something changed (heading or coord) after the move : update it !
			if(!currentMove.equals(newMove)){
				currentMove = newMove;
				currentMoveUpdated();
			}
		}
	}

	@Override
	public void eat(IPrey prey) {
		// Poor prey ... it got eaten :'(
		prey.gotEaten();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.currentMove.getCoord();
	}

	@Override
	public void setFoodMode(IFoodMode _foodMode) {
		this.foodMode = _foodMode;
	}

	@Override
	public void setMoveBehaviour(IMoveBehaviour _moveBehaviour) {
		this.moveBehaviour = _moveBehaviour;
	}

	@Override
	public void setDirection(CardinalPoint _cp) {
		this.currentMove.setCp(_cp);
		switch (_cp) {
			case SOUTH :
				this.greenfootActor.setRotation(90);
				break;
			case EAST :
				this.greenfootActor.setRotation(0);
				break;
			case NORTH :
				this.greenfootActor.setRotation(270);
				break;
			case WEST :
				this.greenfootActor.setRotation(180);
				break;
			default :
				break;
		}
	}

	public void setCoordinates(Coordinates _coord){
		this.currentMove.setCoord(_coord);
		this.greenfootActor.setLocation(_coord.getX(), _coord.getY());
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setGreenfootActor(ActorDelegator _greenfootActor) {
		this.greenfootActor = _greenfootActor;
	}

	private void currentMoveUpdated(){
		setDirection(this.currentMove.getCp());
		setCoordinates(this.currentMove.getCoord());
	}
}
