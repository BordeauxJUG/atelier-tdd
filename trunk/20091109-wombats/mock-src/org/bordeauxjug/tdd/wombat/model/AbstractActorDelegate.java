package org.bordeauxjug.tdd.wombat.model;

public abstract class AbstractActorDelegate implements IActorDelegate{

	private String name;
	private Coordinates coords;
	private ActorDelegator<? extends IActorDelegate> greenfootActor;
	
	protected AbstractActorDelegate(String _name){
		this(_name, new Coordinates(0, 0));
	}
	
	protected AbstractActorDelegate(String _name, Coordinates _coord){
		this.name = _name;
		this.coords = _coord;
		this.greenfootActor = null;
	}
	
	public String getName(){
		return this.name;
	}

	public Coordinates getCoordinates(){
		return this.coords;
	}

	public void setGreenfootActor(ActorDelegator<? extends IActorDelegate> _greenfootActor){
		this.greenfootActor = _greenfootActor;
	}

	public ActorDelegator<? extends IActorDelegate> getGreenfootActor() {
		return greenfootActor;
	}
}
