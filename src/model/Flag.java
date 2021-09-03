package model;

public class Flag extends Piece {
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Flag and sets via set methods rank = -1, 'team' team</p>
	 * @param team is the team that Flag belongs
	 */
	public Flag(Team team) {
		setRank(-1);
		setTeam(team);
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postcondition: return a String with info about this Piece</p>
	 * @return a String with info about this Piece
	 */
	public String toString() {
		return("Flag"+this.getTeam());
	}
}
