package model;

public class Position {
	private int line;
	private int column;
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the line of the position</p>
	 * @return the line of the position
	 */
	public int getPositionLine() {
		return this.line;
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the column of the position</p>
	 * @return the column of the position
	 */
	public int getPositionColumn() {
		return this.column;
	}
	
	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets to the variable line a new value</p>
	 * @param line is the new value that will be assigned to the variable line
	 */
	public void setPositionLine(int line) {
		this.line = line;
	}
	
	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets to the variable column a new value</p>
	 * @param column is the new value that will be assigned to the variable column
	 */
	public void setPositionColumn(int column) {
		this.column = column;
	}
	
	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets new values to this position's line and column</p>
	 * @param line is the new value that will be assigned to the variable line
	 * @param column is the new value that will be assigned to the variable column
	 */
	public void setPosition(int line, int column) {
		this.line = line;
		this.column = column;
	}
}
