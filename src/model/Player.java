package model;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private int numOfRescues;
	public Piece[] alivePieces;
	public ArrayList<Piece> lostPieces;
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Player and sets via set methods 'name' name, 
	 * numOfRescues = 0 and creates a new 30 element array alivePieces</p>
	 * @param name is the name of the Player
	 */
	public Player(String name) {
		this.setName(name);
		setNumOfRescues(0);
		alivePieces = new Piece[30];
		lostPieces = new ArrayList<Piece>();
		if (name == "Player 1") {
			alivePieces[0] = new Dragon(Team.BLUE);
			alivePieces[1] = new Mage(Team.BLUE);
			alivePieces[2] = new Knight(Team.BLUE);
			alivePieces[3] = new Knight(Team.BLUE);
			alivePieces[4] = new BeastRider(Team.BLUE);
			alivePieces[5] = new BeastRider(Team.BLUE);
			alivePieces[6] = new BeastRider(Team.BLUE);
			alivePieces[7] = new Sorceress(Team.BLUE);
			alivePieces[8] = new Sorceress(Team.BLUE);
			alivePieces[9] = new Yeti();
			alivePieces[10] = new Yeti();
			alivePieces[11] = new Elf(Team.BLUE);
			alivePieces[12] = new Elf(Team.BLUE);
			alivePieces[13] = new Dwarf(Team.BLUE);
			alivePieces[14] = new Dwarf(Team.BLUE);
			alivePieces[15] = new Dwarf(Team.BLUE);
			alivePieces[16] = new Dwarf(Team.BLUE);
			alivePieces[17] = new Dwarf(Team.BLUE);
			alivePieces[18] = new Scout(Team.BLUE);
			alivePieces[19] = new Scout(Team.BLUE);
			alivePieces[20] = new Scout(Team.BLUE);
			alivePieces[21] = new Scout(Team.BLUE);
			alivePieces[22] = new Slayer(Team.BLUE);
			alivePieces[23] = new Bomb(Team.BLUE);
			alivePieces[24] = new Bomb(Team.BLUE);
			alivePieces[25] = new Bomb(Team.BLUE);
			alivePieces[26] = new Bomb(Team.BLUE);
			alivePieces[27] = new Bomb(Team.BLUE);
			alivePieces[28] = new Bomb(Team.BLUE);
			alivePieces[29] = new Flag(Team.BLUE);
		}
		else if (name == "Player 2") {	
			alivePieces[0] = new Dragon(Team.RED);
			alivePieces[1] = new Mage(Team.RED);
			alivePieces[2] = new Knight(Team.RED);
			alivePieces[3] = new Knight(Team.RED);
			alivePieces[4] = new BeastRider(Team.RED);
			alivePieces[5] = new BeastRider(Team.RED);
			alivePieces[6] = new BeastRider(Team.RED);
			alivePieces[7] = new Sorceress(Team.RED);
			alivePieces[8] = new Sorceress(Team.RED);
			alivePieces[9] = new LavaBeast();
			alivePieces[10] = new LavaBeast();
			alivePieces[11] = new Elf(Team.RED);
			alivePieces[12] = new Elf(Team.RED);
			alivePieces[13] = new Dwarf(Team.RED);
			alivePieces[14] = new Dwarf(Team.RED);
			alivePieces[15] = new Dwarf(Team.RED);
			alivePieces[16] = new Dwarf(Team.RED);
			alivePieces[17] = new Dwarf(Team.RED);
			alivePieces[18] = new Scout(Team.RED);
			alivePieces[19] = new Scout(Team.RED);
			alivePieces[20] = new Scout(Team.RED);
			alivePieces[21] = new Scout(Team.RED);
			alivePieces[22] = new Slayer(Team.RED);
			alivePieces[23] = new Bomb(Team.RED);
			alivePieces[24] = new Bomb(Team.RED);
			alivePieces[25] = new Bomb(Team.RED);
			alivePieces[26] = new Bomb(Team.RED);
			alivePieces[27] = new Bomb(Team.RED);
			alivePieces[28] = new Bomb(Team.RED);
			alivePieces[29] = new Flag(Team.RED);
		}
	}	
	
	/**
	 * <b><p>Transformer </p></b>
	 * @param choice is the piece that is going to be rescued
	 * @return the Piece that rescued
	 */
	public Piece rescue(int choice) {
		Piece piece = lostPieces.get(choice);
		lostPieces.remove(piece);
		this.numOfRescues++;
		return piece;
	}

	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the name of the Player</p>
	 * @return the name of the Player
	 */
	public String getName() {
		return name;
	}

	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets the name of the Player to name</p>
	 * @param name is the name of Player that will be assigned to the variable name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions: return the number of the rescues this Player has done</p>
	 * @return the number of the rescues this Player has done
	 */
	public int getNumOfRescues() {
		return numOfRescues;
	}

	/**
	 * <b><p>Transformer (Mutative)</p></b>
	 * <p>Postconditions: sets the number of rescues this Player has done to numOfRescues</p>
	 * @param numOfRescues is the new number of rescues this Player has done
	 */
	public void setNumOfRescues(int numOfRescues) {
		this.numOfRescues = numOfRescues;
	}
}
