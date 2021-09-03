package model;

import java.util.ArrayList;

public abstract class MoveablePiece extends Piece{
	
	/**
	 * <b><p>Transformer</p></b>
	 * <p>Postconditions: the Moveable Piece attacks a Piece</p>
	 * @param position1 is the position of the piece that is going to attack
	 * @param position2 is the position of the piece that is going to be attacked
	 * @param board is the board of the game
	 * @param player1 is the player that attacks
	 * @param player2 is the player that is attacked
	 */
	public abstract int attack(Position position1, Position position2, Board board, Player player1, Player player2);
	
	/**
	 * <b><p>Transformer</p></b>
	 * <p>Postconditions: the Moveable Piece moves in other position</p>
	 * @param position1 is the position of the piece that is going to move
	 * @param position2 is the position where is going to move
	 * @param board is the board of the game
	 */
	public void move(Position position1, Position position2, Board board) {
		board.setBoardElement(board.getBoardElement(position1), position2);
		board.setBoardElement(null, position1);
	}
}
