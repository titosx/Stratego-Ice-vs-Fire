package model;

public class Piece {
	private int rank;
	private Team team;
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the Piece's rank
	 * @return the Piece's rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets the rank of this Piece to rank</p>
	 * @param rank is the value that will assigned to the variable rank.
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the Piece's team</p>
	 * @return the Piece's team
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets the team of this Piece to team.</p>
	 * @param team is the value that will assigned to the variable team.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
}