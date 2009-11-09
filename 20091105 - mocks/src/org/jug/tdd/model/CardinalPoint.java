package org.jug.tdd.model;

public enum CardinalPoint {


	NORTH(0, -1),

	SOUTH(0, 1),

	EAST(1, 0),

	WEST(-1, 0);

	private int x, y;


	private CardinalPoint(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}


	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

}
