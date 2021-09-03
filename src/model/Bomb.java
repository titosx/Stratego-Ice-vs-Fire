package model;

public class Bomb extends Piece {
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Bomb and sets via set methods rank = 0, 
	 * 'team' team</p>
	 * @param team is the team that Bomb Belongs
	 */
	public Bomb(Team team) {
		setRank(0);
		setTeam(team);
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postcondition: return a String with info about this Piece</p>
	 * @return a String with info about this Piece
	 */
	public String toString() {
		return("Bomb"+this.getTeam());
	}
	
}
