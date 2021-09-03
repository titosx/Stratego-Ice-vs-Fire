package model;

public abstract class SpecialMoveablePiece extends MoveablePiece {
		
	private boolean hasUsedPower;

	/**
	 * <b><p>Observer</p></b>
	 * <p>Postconditions: returns if the Special Moveable Piece has used it's power</p>
	 * @return 
	 */
	public boolean getHasUsedPower() {
		return hasUsedPower;
	}

	/**
	 * <b><p>Transformer(Mutative)</p></b>
	 * <p>Postconditions: sets the variable hasUsedPower with a new value</p>
	 * @return hasUsedPower is the new value that will replace the old value
	 */
	public void setHasUsedPower(boolean hasUsedPower) {
		this.hasUsedPower = hasUsedPower;
	}
	

}
