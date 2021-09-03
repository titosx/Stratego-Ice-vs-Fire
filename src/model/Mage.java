package model;

import java.util.ArrayList;

public class Mage extends MoveablePiece{

	private int numOfRescues;
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Mage and sets via set methods rank = 9,  
	 * 'team' team, numOfRescues = 0</p>
	 * @param team is the team that Mage belongs
	 */
	public Mage(Team team) {
		setRank(9);
		setTeam(team);
		setNumOfRescues(0);
	}
	
	/**
	 * <b><p>Transformer</p></b>
	 * <p>Postconditions: the Mage attacks a Piece</p>
	 * @param position1 is the position of the piece that is going to attack
	 * @param position2 is the position of the piece that is going to be attacked
	 * @param board is the board of the game
	 * @param player1 is the player that attacks
	 * @param player2 is the player that is attacked
	 */
	public int attack(Position position1, Position position2, Board board, Player player1, Player player2) {
		if ((board.getBoardElement(position2).getRank() == 1) || (board.getBoardElement(position2).getRank() == 2) || (board.getBoardElement(position2).getRank() == 3) || (board.getBoardElement(position2).getRank() == 4) || (board.getBoardElement(position2).getRank() == 5) || (board.getBoardElement(position2).getRank() == 6) || (board.getBoardElement(position2).getRank() == 7) || (board.getBoardElement(position2).getRank() == 8) || (board.getBoardElement(position2).getRank() == -1)) {
			player2.lostPieces.add(board.getBoardElement(position2));
			board.setBoardElement(board.getBoardElement(position1), position2);
			board.setBoardElement(null, position1);
			board.setBoardElement(null, position1);
			return 1;
		}
		else if ((board.getBoardElement(position2).getRank() == 10) || (board.getBoardElement(position2).getRank() == 0)) {
			player1.lostPieces.add(board.getBoardElement(position1));
			board.setBoardElement(null, position1);
			return 2;
		}
		else if (board.getBoardElement(position2).getRank() == 9) {
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
	 * <p>Postconditions: return the number of the rescues this Mage has done</p>
	 * @return the number of the rescues this Mage has done
	 */
	public int getNumOfRescues() {
		return numOfRescues;
	}

	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets the number of rescues this Mage has done to numOfRescues</p>
	 * @param numOfRescues is the new number of rescues this Mage has done
	 */
	public void setNumOfRescues(int numOfRescues) {
		this.numOfRescues = numOfRescues;
	}

	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postcondition: return a String with info about this Piece</p>
	 * @return a String with info about this Piece
	 */
	public String toString() {
		return("Mage"+this.getTeam());
	}
}
