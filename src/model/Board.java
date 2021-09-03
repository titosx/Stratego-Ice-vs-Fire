package model;

public class Board {
	private Piece board[][];
		
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new board</p>
	 */
	public Board() {
		board = new Piece[8][10];
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the element of the array with 'position' position</p>
	 * @param i is the line of the position that is going to be returned
	 * @param j is the column of the position that is going to be returned
	 * @return the element of the array with position 'position'
	 */
	public Piece getBoardElement(int i, int j) {
		return board[i][j];
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the element of the array with 'position' position</p>
	 * @param position is the position of the array's element that is going to be returned
	 * @return the element of the array with position 'position'
	 */
	public Piece getBoardElement(Position position) {
		return board[position.getPositionLine()][position.getPositionColumn()];
	}

	/**
	 * Transformer (Mutative)
	 * <p>Postconditions: sets a new piece in the array's element with 'position' position</p>
	 * @param piece is the piece that is going to fill the array's element 
	 * @param position is the position of the array's element
	 */
	public void setBoardElement(Piece piece, Position position) {
		board[position.getPositionLine()][position.getPositionColumn()] = piece; 
	}
	
	
}
