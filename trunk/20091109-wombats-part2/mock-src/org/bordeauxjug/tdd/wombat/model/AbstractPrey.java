package org.bordeauxjug.tdd.wombat.model;

public class AbstractPrey extends AbstractActorDelegate implements IPrey {

	private int energyValue;
	private Kingdom kingdom;
	private boolean isAlive;
	
	public AbstractPrey(String _name, Kingdom _kingdom){
		this(_name, new Coordinates(0, 0), _kingdom);
	}

	public AbstractPrey(String _name, Coordinates _coord, Kingdom _kingdom){
		super(_name, _coord);
		this.kingdom = _kingdom;
		this.isAlive = true;
	}

	@Override
	public int getEnergyValue() {
		return this.energyValue;
	}

	@Override
	public Kingdom getKingdom() {
		return this.kingdom;
	}

	@Override
	public void gotEaten() {
		this.isAlive = false;
	}

	@Override
	public boolean isAlive() {
		return this.isAlive;
	}

	@Override
	public void act() {
		// Leaf won't move !
	}
}
