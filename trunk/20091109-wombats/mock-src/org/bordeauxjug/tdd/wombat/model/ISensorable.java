package org.bordeauxjug.tdd.wombat.model;

public interface ISensorable<T extends ISensor> {

	void setSensor(T sensor);
}
