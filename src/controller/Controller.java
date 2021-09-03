package controller;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.*;
import view.*;

public class Controller {
	public Board board;
	public Player p1,p2;
	private int round;
	Position board_position;
	int random_i, random_j;
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new controller with 2 players, creates a new 
	 * board for the pieces, initializes the pieces for the players and initialize
     * some int or boolean variables</p>
	 */
	public Controller(){
		board = new Board();
		round = 1;
		p1 = new Player("Player 1");
		p2 = new Player("Player 2");
	}
	
	
	
	/** <b><p>Accessor(Selector)</p></b>
	 * <p>Postconditions: return a player's choice from the board</p>
	 * @param pos is the position of the piece that player chose
	 * @return the piece that player chose
	 */
	public Piece choice(Position pos) {
		
		return null;
	}
	
	/**
	 * <b><p>Transformer</p></b>
	 * <p>Postconditions: Plays the turn of the player.
	 * @param button1 is the first button player clicked
	 * @param button2 is the second button player clicked
	 */
	public int PlayTurn(ExtendedButton button1, ExtendedButton button2) {
		int ret, i;
		Position pos = new Position();
		Position pos1 = new Position();
		Position pos2 = new Position();
		pos1.setPosition(button1.getI(), button1.getJ());
		pos2.setPosition(button2.getI(), button2.getJ());
		
		//scout move
		if ((board.getBoardElement(pos2) == null) && (board.getBoardElement(pos1) instanceof Scout)) {
			if (pos1.getPositionColumn() == pos2.getPositionColumn()) {
				if (pos1.getPositionLine() > pos2.getPositionLine()) {
					i = pos2.getPositionLine() + 1;
					while (i < pos1.getPositionLine()) {
						pos.setPosition(i, pos1.getPositionColumn());
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Move");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						piece.move(pos1, pos2, board);
						round++;
						return 1;
				}
				else {
					i = pos1.getPositionLine() + 1;
					while (i < pos2.getPositionLine()) {
						pos.setPosition(i, pos1.getPositionColumn());
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Move");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						piece.move(pos1, pos2, board);
						round++;
						return 1;
				}
			}
			else if (pos1.getPositionLine() == pos2.getPositionLine()) {
				if (pos1.getPositionColumn() > pos2.getPositionColumn()) {
					i = pos2.getPositionColumn() + 1;
					while (i < pos1.getPositionColumn()) {
						pos.setPosition(pos1.getPositionLine(), i);
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Move");
							return 0;
						}
						i++;
					}
					Scout piece = (Scout) board.getBoardElement(pos1);
					piece.move(pos1, pos2, board);
					round++;
					return 1;
				}
				else {
					i = pos1.getPositionColumn() + 1;
					while (i < pos2.getPositionColumn()) {
						pos.setPosition(pos1.getPositionLine(), i);
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Move");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						piece.move(pos1, pos2, board);
						round++;
						return 1;
				}
			}
		} //scout attack
		else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1) instanceof Scout) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
			if (pos1.getPositionColumn() == pos2.getPositionColumn()) {
				if (pos1.getPositionLine() > pos2.getPositionLine()) {
					i = pos2.getPositionLine() + 1;
					while (i < pos1.getPositionLine()) {
						pos.setPosition(i, pos1.getPositionColumn());
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Attack");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						if (round%2 == 0)
							ret = piece.attack(pos1, pos2, board, p2, p1);
						else
							ret = piece.attack(pos1, pos2, board, p1, p2);
						if (ret == 1) {
							round++;
							return 2;
						}
						else if (ret == 2) {
							round++;
							return 3;
						}
						else if (ret == 3) {
							round++;
							return 4;
						}
				}
				else {
					i = pos1.getPositionLine() + 1;
					while (i < pos2.getPositionLine()) {
						pos.setPosition(i, pos1.getPositionColumn());
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Attack");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						if (round%2 == 0)
							ret = piece.attack(pos1, pos2, board, p2, p1);
						else
							ret = piece.attack(pos1, pos2, board, p1, p2);
						if (ret == 1) {
							round++;
							return 2;
						}
						else if (ret == 2) {
							round++;
							return 3;
						}
						else if (ret == 3) {
							round++;
							return 4;
						}
				}
			}
			else if (pos1.getPositionLine() == pos2.getPositionLine()) {
				if (pos1.getPositionColumn() > pos2.getPositionColumn()) {
					i = pos2.getPositionColumn() + 1;
					while (i < pos1.getPositionColumn()) {
						pos.setPosition(pos1.getPositionLine(), i);
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Attack");
							return 0;
						}
						i++;
					}
					Scout piece = (Scout) board.getBoardElement(pos1);
						if (round%2 == 0)
							ret = piece.attack(pos1, pos2, board, p2, p1);
						else
							ret = piece.attack(pos1, pos2, board, p1, p2);
						if (ret == 1) {
							round++;
							return 2;
						}
						else if (ret == 2) {
							round++;
							return 3;
						}
						else if (ret == 3) {
							round++;
							return 4;
						}
				}
				else {
					i = pos1.getPositionColumn() + 1;
					while (i < pos2.getPositionColumn()) {
						pos.setPosition(pos1.getPositionLine(), i);
						if ((board.getBoardElement(pos) instanceof Piece) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 2) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 3) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 3 && pos.getPositionColumn() == 7) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 6) || (pos.getPositionLine() == 4 && pos.getPositionColumn() == 7)) {
							System.out.println("Can't Attack");
							return 0;
						}
						i++;
					}
						Scout piece = (Scout) board.getBoardElement(pos1);
						if (round%2 == 0)
							ret = piece.attack(pos1, pos2, board, p2, p1);
						else
							ret = piece.attack(pos1, pos2, board, p1, p2);
						if (ret == 1) {
							round++;
							return 2;
						}
						else if (ret == 2) {
							round++;
							return 3;
						}
						else if (ret == 3) {
							round++;
							return 4;
						}
				}
			}
		} //knight or beast rider speed
		else if (((board.getBoardElement(pos1) instanceof Knight) || (board.getBoardElement(pos1) instanceof BeastRider)) && (!(((button1.getI() == button2.getI()) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 1)) || ((button1.getJ() == button2.getJ()) && ((int)Math.abs(button1.getI()-button2.getI()) == 1))))) {
			if (((button1.getI() == button2.getI()) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 2)) || ((button1.getJ() == button2.getJ()) && ((int)Math.abs(button1.getI()-button2.getI()) == 2)) || (((int)Math.abs(button1.getI()-button2.getI()) == 1) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 2))) {
				if (button1.getI() == button2.getI()) {
					if (button1.getJ() > button2.getJ()) {
						pos.setPosition(button1.getI(), button2.getJ()+1);
						if (board.getBoardElement(pos) instanceof Piece) {
							System.out.println("Can't Attack");
							return 0;
						}
						MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
						if (board.getBoardElement(pos2) == null) {
							piece.move(pos1, pos2, board);
							round++;
							return 1;
						}
						else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
							if (round%2 == 0)
								ret = piece.attack(pos1, pos2, board, p2, p1);
							else
								ret = piece.attack(pos1, pos2, board, p1, p2);
							if (ret == 1) {
								round++;
								return 2;
							}
							else if (ret == 2) {
								round++;
								return 3;
							}
							else if (ret == 3) {
								round++;
								return 4;
							}
						}
					}
					else if (button2.getJ() > button1.getJ()) {
						pos.setPosition(button1.getI(), button1.getJ()+1);
						if (board.getBoardElement(pos) instanceof Piece) {
							System.out.println("Can't Attack");
							return 0;
						}
						MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
						if (board.getBoardElement(pos2) == null) {
							piece.move(pos1, pos2, board);
							round++;
							return 1;
						}
						else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
							if (round%2 == 0)
								ret = piece.attack(pos1, pos2, board, p2, p1);
							else
								ret = piece.attack(pos1, pos2, board, p1, p2);
							if (ret == 1) {
								round++;
								return 2;
							}
							else if (ret == 2) {
								round++;
								return 3;
							}
							else if (ret == 3) {
								round++;
								return 4;
							}
						}
					}
				}
				else if (button1.getJ() == button2.getJ()) {
					if (button1.getI() > button2.getI()) {
						pos.setPosition(button2.getI()+1, button1.getJ());
						if (board.getBoardElement(pos) instanceof Piece) {
							System.out.println("Can't Attack");
							return 0;
						}
						MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
						if (board.getBoardElement(pos2) == null) {
							piece.move(pos1, pos2, board);
							round++;
							return 1;
						}
						else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
							if (round%2 == 0)
								ret = piece.attack(pos1, pos2, board, p2, p1);
							else
								ret = piece.attack(pos1, pos2, board, p1, p2);
							if (ret == 1) {
								round++;
								return 2;
							}
							else if (ret == 2) {
								round++;
								return 3;
							}
							else if (ret == 3) {
								round++;
								return 4;
							}
						}
					}
					else if (button2.getI() > button1.getI()) {
						pos.setPosition(button1.getI()+1, button1.getJ());
						if (board.getBoardElement(pos) instanceof Piece) {
							System.out.println("Can't Attack");
							return 0;
						}
						MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
						if (board.getBoardElement(pos2) == null) {
							piece.move(pos1, pos2, board);
							round++;
							return 1;
						}
						else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
							if (round%2 == 0)
								ret = piece.attack(pos1, pos2, board, p2, p1);
							else
								ret = piece.attack(pos1, pos2, board, p1, p2);
							if (ret == 1) {
								round++;
								return 2;
							}
							else if (ret == 2) {
								round++;
								return 3;
							}
							else if (ret == 3) {
								round++;
								return 4;
							}
						}
					}
				}
			}
			else {
				if (((int)Math.abs(button1.getI()-button2.getI()) == 1) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 1)) {
					if (!((board.getBoardElement(button1.getI(), button2.getJ()) instanceof Piece) || (button1.getI() == 3 && button2.getJ() == 2) || (button1.getI() == 3 && button2.getJ() == 3) || (button1.getI() == 4 && button2.getJ() == 2) || (button1.getI() == 4 && button2.getJ() == 3) || (button1.getI() == 3 && button2.getJ() == 6) || (button1.getI() == 3 && button2.getJ() == 7) || (button1.getI() == 4 && button2.getJ() == 6) || (button1.getI() == 4 && button2.getJ() == 7)) || (!((board.getBoardElement(button2.getI(), button1.getJ()) instanceof Piece) || (button2.getI() == 3 && button1.getJ() == 2) || (button2.getI() == 3 && button1.getJ() == 3) || (button2.getI() == 4 && button1.getJ() == 2) || (button2.getI() == 4 && button1.getJ() == 3) || (button2.getI() == 3 && button1.getJ() == 6) || (button2.getI() == 3 && button1.getJ() == 7) || (button2.getI() == 4 && button1.getJ() == 6) || (button2.getI() == 4 && button1.getJ() == 7)))) {
						MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
						if (board.getBoardElement(pos2) == null) {
							piece.move(pos1, pos2, board);
							round++;
							return 1;
						}
						else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
							if (round%2 == 0)
								ret = piece.attack(pos1, pos2, board, p2, p1);
							else
								ret = piece.attack(pos1, pos2, board, p1, p2);
							if (ret == 1) {
								round++;
								return 2;
							}
							else if (ret == 2) {
								round++;
								return 3;
							}
							else if (ret == 3) {
								round++;
								return 4;
							}
						}
					}
					else
						System.out.println("Can't Move or Attack.");
				}
			}
		} //elf bows
		else if ((board.getBoardElement(pos1) instanceof Elf) && (board.getBoardElement(pos2) != null)) {
			if (((int)Math.abs(pos1.getPositionLine()-pos2.getPositionLine()) < 3) && ((int)Math.abs(pos1.getPositionColumn()-pos2.getPositionColumn()) < 3) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {
				Elf piece = (Elf)board.getBoardElement(pos1);
				if (round%2 == 0)
					ret = piece.powerBows(pos2, board, p1);
				else
					ret = piece.powerBows(pos2, board, p2);
				if (ret == 1) {
					round++;
					return 5;
				}
				else {
					round++;
					return 6;
				}
			}	
		} //normal move
		else if ((board.getBoardElement(pos2) == null) && (board.getBoardElement(pos1) instanceof MoveablePiece)) {
			MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
			if (((button1.getI() == button2.getI()) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 1)) || ((button1.getJ() == button2.getJ()) && ((int)Math.abs(button1.getI()-button2.getI()) == 1))) {
				piece.move(pos1, pos2, board);
				round++;
				return 1;
			}
		} //normal attack
		else if ((board.getBoardElement(pos2) != null) && (board.getBoardElement(pos1) instanceof MoveablePiece) && (board.getBoardElement(pos1).getTeam() != board.getBoardElement(pos2).getTeam())) {  
			MoveablePiece piece = (MoveablePiece)board.getBoardElement(pos1);
			if (((button1.getI() == button2.getI()) && ((int)Math.abs(button1.getJ()-button2.getJ()) == 1)) || ((button1.getJ() == button2.getJ()) && ((int)Math.abs(button1.getI()-button2.getI()) == 1))) {
				if (round%2 == 0)
					ret = piece.attack(pos1, pos2, board, p2, p1);
				else
					ret = piece.attack(pos1, pos2, board, p1, p2);
				if (ret == 1) {
					round++;
					return 2;
				}
				else if (ret == 2) {
					round++;
					return 3;
				}
				else if (ret == 3) {
					round++;
					return 4;
				}
			}
		}
		return 0;
	}
	
	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postconditions:> return the number of the round</p>
	 * @return the number of the round
	 */
	public int getRound() {
		return round;
	}
	
	/** <b><p>Transformer</p></b>
	 * <p>Preconditions: the piece from position pos1 can't be Scout and 
	 * must be in the last line</p>
	 * <b>Postconditions: the piece with position pos1 rescue a Piece</p>
	 * @param pos1 is the position of the piece that will do a rescue
	 */
	public Position Rescue(Position pos1) {
		Position position = new Position();
		int piecerescues = 0;
		int playerrescues = 0;
		
		if (board.getBoardElement(pos1) instanceof BeastRider)
			piecerescues = ((BeastRider)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Dragon)
			piecerescues = ((Dragon)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Dwarf)
			piecerescues = ((Dwarf)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Elf)
			piecerescues = ((Elf)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Knight)
			piecerescues = ((Knight)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof LavaBeast)
			piecerescues = ((LavaBeast)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Mage)
			piecerescues = ((Mage)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Slayer)
			piecerescues = ((Slayer)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Sorceress)
			piecerescues = ((Sorceress)board.getBoardElement(pos1)).getNumOfRescues();
		else if (board.getBoardElement(pos1) instanceof Yeti)
			piecerescues = ((Yeti)board.getBoardElement(pos1)).getNumOfRescues();
		if (pos1.getPositionLine() == 0)
			playerrescues = p2.getNumOfRescues();
		else if (pos1.getPositionLine() == 7)
			playerrescues = p1.getNumOfRescues();
			
		if ((board.getBoardElement(pos1) instanceof Scout) || (piecerescues > 0) || (playerrescues > 2))
			return null;
		
		if (pos1.getPositionLine() == 0) {
			RescueDialog res = new RescueDialog(p2.lostPieces);
			if (res.choice() != -1) {
				Piece piece = p2.rescue(res.choice());
				int random_i = new Random().nextInt(7-5 + 1) + 5;
				int random_j = new Random().nextInt(9-0 + 1) + 0;
				Position board_position = new Position();
				board_position.setPosition(random_i, random_j);
				while (board.getBoardElement(board_position) != null) {
					random_i = new Random().nextInt(7-5 + 1) + 5;
					random_j = new Random().nextInt(9-0 + 1) + 0;
					board_position.setPosition(random_i, random_j);
				}
				position.setPosition(random_i, random_j);
				board.setBoardElement(piece, board_position);
			}
			else
				return null;
		}
		else if (pos1.getPositionLine() == 7) {
			RescueDialog res = new RescueDialog(p1.lostPieces);
			if (res.choice() != -1) {
				Piece piece = p1.rescue(res.choice());
				int random_i = new Random().nextInt(2-0 + 1) + 0;
				int random_j = new Random().nextInt(9-0 + 1) + 0;
				Position board_position = new Position();
				board_position.setPosition(random_i, random_j);
				while (board.getBoardElement(board_position) != null) {
					random_i = new Random().nextInt(2-0 + 1) + 0;
					random_j = new Random().nextInt(9-0 + 1) + 0;
					board_position.setPosition(random_i, random_j);
				}
				position.setPosition(random_i, random_j);
				board.setBoardElement(piece, board_position);
			}
			else
				return null;
		}
		if (board.getBoardElement(pos1) instanceof BeastRider) {
			int rescues = ((BeastRider)board.getBoardElement(pos1)).getNumOfRescues();
			((BeastRider)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Dragon) {
			int rescues = ((Dragon)board.getBoardElement(pos1)).getNumOfRescues();
			((Dragon)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Dwarf) {
			int rescues = ((Dwarf)board.getBoardElement(pos1)).getNumOfRescues();
			((Dwarf)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Elf) {
			int rescues = ((Elf)board.getBoardElement(pos1)).getNumOfRescues();
			((Elf)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Knight) {
			int rescues = ((Knight)board.getBoardElement(pos1)).getNumOfRescues();
			((Knight)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof LavaBeast) {
			int rescues = ((LavaBeast)board.getBoardElement(pos1)).getNumOfRescues();
			((LavaBeast)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Mage) {
			int rescues = ((Mage)board.getBoardElement(pos1)).getNumOfRescues();
			((Mage)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Slayer) {
			int rescues = ((Slayer)board.getBoardElement(pos1)).getNumOfRescues();
			((Slayer)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Sorceress) {
			int rescues = ((Sorceress)board.getBoardElement(pos1)).getNumOfRescues();
			((Sorceress)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		else if (board.getBoardElement(pos1) instanceof Yeti) {
			int rescues = ((Yeti)board.getBoardElement(pos1)).getNumOfRescues();
			((Yeti)board.getBoardElement(pos1)).setNumOfRescues(1);
		}
		return position;
	}
}