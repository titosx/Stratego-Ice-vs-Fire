package model;

public class Scout extends MoveablePiece {
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Scout and sets via set methods rank = 2, 'team' team</p>
	 * @param team is the team that Scout belongs
	 */
	public Scout(Team team) {
		setRank(2);
		setTeam(team);
	}
	
	/**
	 * <b><p>Transformer</p></b>
	 * <p>Postconditions: the Scout attacks a Piece</p>
	 * @param position1 is the position of the piece that is going to attack
	 * @param position2 is the position of the piece that is going to be attacked
	 * @param board is the board of the game
	 * @param player1 is the player that attacks
	 * @param player2 is the player that is attacked
	 */
	public int attack(Position position1, Position position2, Board board, Player player1, Player player2) {
		if ((board.getBoardElement(position2).getRank() == 1) || (board.getBoardElement(position2).getRank() == -1)) {
			player2.lostPieces.add(board.getBoardElement(position2));
			board.setBoardElement(board.getBoardElement(position1), position2);
			board.setBoardElement(null, position1);
			board.setBoardElement(null, position1);
			return 1;
		}
		else if ((board.getBoardElement(position2).getRank() == 10) || (board.getBoardElement(position2).getRank() == 9) || (board.getBoardElement(position2).getRank() == 8) || (board.getBoardElement(position2).getRank() == 7) || (board.getBoardElement(position2).getRank() == 6) || (board.getBoardElement(position2).getRank() == 5) || (board.getBoardElement(position2).getRank() == 4)|| (board.getBoardElement(position2).getRank() == 3)|| (board.getBoardElement(position2).getRank() == 0)) {
			player1.lostPieces.add(board.getBoardElement(position1));
			board.setBoardElement(null, position1);
			return 2;
		}
		else if (board.getBoardElement(position2).getRank() == 2) {
			player1.lostPieces.add(board.getBoardElement(position1));
			board.setBoardElement(null, position1);
			player2.lostPieces.add(board.getBoardElement(position2));
			board.setBoardElement(null, position2);
			return 3;
		}
		return 0;
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postcondition: return a String with info about this Piece</p>
	 * @return a String with info about this Piece
	 */
	public String toString() {
		return("Scout"+this.getTeam());
	}
}
