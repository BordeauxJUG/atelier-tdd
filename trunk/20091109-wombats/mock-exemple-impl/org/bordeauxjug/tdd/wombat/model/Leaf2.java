package org.bordeauxjug.tdd.wombat.model;

public class Leaf2 extends AbstractPrey {

	public Leaf2(String _name){
		super(_name, Kingdom.VEGETAL);
	}
	
	public Leaf2(String _name, Coordinates _coord){
		super(_name, _coord, Kingdom.VEGETAL);
	}
}
