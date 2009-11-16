package org.bordeauxjug.tdd.wombat.model;

public class MoveStatus {

	private CardinalPoint cp;
	private Coordinates coord;
	
	public MoveStatus(CardinalPoint _cp, Coordinates _coord){
		this.cp = _cp;
		this.coord = _coord;
	}

	public CardinalPoint getCp() {
		return cp;
	}

	public Coordinates getCoord() {
		return coord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveStatus other = (MoveStatus) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		return true;
	}

	public void setCp(CardinalPoint cp) {
		this.cp = cp;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}
	
}
