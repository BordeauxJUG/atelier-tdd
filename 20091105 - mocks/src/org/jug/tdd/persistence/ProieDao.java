package org.jug.tdd.persistence;

import java.util.List;

import org.jug.tdd.model.Coordinates;
import org.jug.tdd.model.IPrey;

public class ProieDao
{

	// Create or update, the prey can be dead
	public IPrey save(IPrey prey)
	{
		return prey;

	}

	public IPrey load(Coordinates where)
	{
		return null;

	}

	public List<IPrey> getAll()
	{

		return null;
	}
}
