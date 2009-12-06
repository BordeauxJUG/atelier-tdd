package org.bordeauxjug.tdd.wombat.model;

import greenfoot.World;
import greenfoot.core.WorldHandler;

import java.util.Iterator;
import java.util.List;


public class Wombat2 extends AbstractActorDelegate implements IPredator {

	private IMoveBehaviour moveBehaviour;
	private IFoodMode foodMode;
	private MoveStatus currentMove;
	
	public Wombat2(String _name){
		this(_name, new MoveStatus(CardinalPoint.SOUTH, new Coordinates(0,0)),
				new StraightLineMoveBehaviour(), 
				new UniqueFoodMode(Kingdom.VEGETAL));
	}
	
	public Wombat2(String _name, MoveStatus _currentMove, 
			IMoveBehaviour _moveBehaviour, IFoodMode _foodMode){
		super(_name, _currentMove.getCoord());
		this.moveBehaviour = _moveBehaviour;
		this.foodMode = _foodMode;
		this.currentMove = _currentMove;
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
			MoveStatus newMove = moveBehaviour.move(currentMove);
			
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
				this.getGreenfootActor().setRotation(90);
				break;
			case EAST :
				this.getGreenfootActor().setRotation(0);
				break;
			case NORTH :
				this.getGreenfootActor().setRotation(270);
				break;
			case WEST :
				this.getGreenfootActor().setRotation(180);
				break;
			default :
				break;
		}
	}

	public void setCoordinates(Coordinates _coord){
		this.currentMove.setCoord(_coord);
		this.getGreenfootActor().setLocation(_coord.getX(), _coord.getY());
	}

	private void currentMoveUpdated(){
		setDirection(this.currentMove.getCp());
		setCoordinates(this.currentMove.getCoord());
	}
}
