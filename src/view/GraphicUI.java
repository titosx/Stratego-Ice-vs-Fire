package view;

import controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import model.*;



public class GraphicUI extends JFrame {
	
	private boolean cardSelected;
	public ExtendedButton[][] buttons = new ExtendedButton[8][10];
	private ExtendedButton selectedButton;
	private GridLayout grid = new GridLayout(8,10);
	public ClassLoader cldr = this.getClass().getClassLoader();
	public URL imageurl;
	private Controller c1;
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new window</p>
	 */
    public GraphicUI() {
    	c1 = new Controller();
    	setTitle("Stratego");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);
		imageurl = cldr.getResource("stratego_small.jpg");
		setIconImage(new ImageIcon(imageurl).getImage());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 10));
		CardListener cl = new CardListener();
		for (int i=0; i<8; i++) {
			for (int j=0; j<10; j++) {
				buttons[i][j] = new ExtendedButton();
				buttons[i][j].setI(i);
				buttons[i][j].setJ(j);
				buttons[i][j].addMouseListener(cl);
			}
		}
		buttons[3][2].setEnabled(false);
		buttons[3][3].setEnabled(false);
		buttons[3][6].setEnabled(false);
		buttons[3][7].setEnabled(false);
		buttons[4][2].setEnabled(false);
		buttons[4][3].setEnabled(false);
		buttons[4][6].setEnabled(false);
		buttons[4][7].setEnabled(false);
		buttons[3][2].setName("ForbiddenPosition");
		buttons[3][3].setName("ForbiddenPosition");
		buttons[3][6].setName("ForbiddenPosition");
		buttons[3][7].setName("ForbiddenPosition");
		buttons[4][2].setName("ForbiddenPosition");
		buttons[4][3].setName("ForbiddenPosition");
		buttons[4][6].setName("ForbiddenPosition");
		buttons[4][7].setName("ForbiddenPosition");
		initializePieces();
		NextTurn();
		for (int i=0; i<8; i++) {
			for (int j=0; j<10; j++)
				panel.add(buttons[i][j]);
		}
		
		add(panel);
		setVisible(true);
    }
    
    public void initializePieces() {
    	int random_i, random_j;
    	Position board_position= new Position();
    	
		for (int i=0; i<30; i++) {
			random_i = new Random().nextInt(2-0 + 1) + 0;
			random_j = new Random().nextInt(9-0 + 1) + 0;
			board_position.setPosition(random_i, random_j);
			while (c1.board.getBoardElement(board_position) != null) {
				random_i = new Random().nextInt(2-0 + 1) + 0;
				random_j = new Random().nextInt(9-0 + 1) + 0;
				board_position.setPosition(random_i, random_j);
			}
				c1.board.setBoardElement(c1.p1.alivePieces[i], board_position);
		}
		for (int i=0; i<30; i++) {
			random_i = new Random().nextInt(7-5 + 1) + 5;
			random_j = new Random().nextInt(9-0 + 1) + 0;
			board_position.setPosition(random_i, random_j);
			while (c1.board.getBoardElement(board_position) != null) {
				random_i = new Random().nextInt(7-5 + 1) + 5;
				random_j = new Random().nextInt(9-0 + 1) + 0;
				board_position.setPosition(random_i, random_j);
			}
				c1.board.setBoardElement(c1.p2.alivePieces[i], board_position);
		}
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<10; j++) {
				buttons[i][j].setBackground(Color.WHITE);
				if (c1.board.getBoardElement(i, j) != null) {
					imageurl = cldr.getResource(c1.board.getBoardElement(i, j).toString() + ".png");
					ImageIcon img = new ImageIcon(imageurl);
					Image img2 = img.getImage();
					Image img3 = img2.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
					img = new ImageIcon(img3);
					buttons[i][j].setIcon(img);
					buttons[i][j].setName(c1.board.getBoardElement(i, j).toString());
				}
				else if ((c1.board.getBoardElement(i, j) == null) && ((i == 3 && j == 2) || (i == 3 && j == 3) || (i == 3 && j == 6) || (i == 3 && j == 7) ||  (i == 4 && j == 2) || (i == 4 && j == 3) || (i == 4 && j == 6) || (i == 4 && j == 7)))
					 buttons[i][j].setBackground(Color.YELLOW);
					
			}
		}
		cardSelected = false;
	}
    
    public void CheckForWin() {
    	NewExitDialog newgame;
    	boolean p1moveable = false;
    	boolean p2moveable = false;
    	for (int i=0; i<c1.p1.lostPieces.size(); i++) {
    		if (c1.p1.lostPieces.get(i) instanceof Flag) {
    			newgame = new NewExitDialog("Player1");
    			if (newgame.choice() == 1) {
    				setVisible(false);
    				new GraphicUI();
    			}
    			else
    				System.exit(0);
    		}
    	}
    	for (int i=0; i<c1.p2.lostPieces.size(); i++) {
    		if (c1.p2.lostPieces.get(i) instanceof Flag){
    			newgame = new NewExitDialog("Player2");
    			if (newgame.choice() == 1) {
    				setVisible(false);
    				new GraphicUI();
    			}
    			else
    				System.exit(0);
			}
    	}
    	for (int i=0; i<8; i++) {
    		for (int j=0; j<10; j++) {
    			if ((c1.board.getBoardElement(i, j) instanceof MoveablePiece) && (c1.board.getBoardElement(i, j).getTeam() == Team.BLUE))
    				p1moveable = true;
    			else if ((c1.board.getBoardElement(i, j) instanceof MoveablePiece) && (c1.board.getBoardElement(i, j).getTeam() == Team.RED))
    				p2moveable = true;
    		}
    	}
    	if (p1moveable == false) {
    		newgame = new NewExitDialog("Player2");
    		if (newgame.choice() == 1) {
				setVisible(false);
				new GraphicUI();
			}
    		else
				System.exit(0);
    	}
    	if (p2moveable == false) {
    		newgame = new NewExitDialog("Player1");
    		if (newgame.choice() == 1) {
				setVisible(false);
				new GraphicUI();
			}
    		else
				System.exit(0);
    	}
    }
    
    
    public void NextTurn() {
    	CheckForWin();
    	int k=0;
    	for (int j=0; j<10; j++) {
   			if ((c1.board.getBoardElement(k, j) instanceof Piece) && (c1.board.getBoardElement(k, j).getTeam() == Team.RED)) {
   				Position pos1 = new Position();
   				pos1.setPosition(k, j);
   				Position rescued = c1.Rescue(pos1);
   				if (rescued != null)
   					buttons[rescued.getPositionLine()][rescued.getPositionColumn()].setName(c1.board.getBoardElement(rescued).toString());
   			}
    	}
    	k=7;
    	for (int j=0; j<10; j++) {
    		if ((c1.board.getBoardElement(k, j) instanceof Piece) && (c1.board.getBoardElement(k, j).getTeam() == Team.BLUE)) {
    			Position pos1 = new Position();
   				pos1.setPosition(k, j);
   				Position rescued = c1.Rescue(pos1);
   				if (rescued != null)
   					buttons[rescued.getPositionLine()][rescued.getPositionColumn()].setName(c1.board.getBoardElement(rescued).toString());
    		}
    	}
    	for (int i=0; i<8; i++) {
    		for (int j=0; j<10; j++) {
    			if (c1.board.getBoardElement(i, j) == null) {
    				continue;
    			}
   				if (c1.getRound()%2 == 0) {
   					if (c1.board.getBoardElement(i, j).getTeam() == Team.BLUE) { 
   						imageurl = cldr.getResource("blueHidden.png");
   						ImageIcon img = new ImageIcon(imageurl);
   						Image img2 = img.getImage();
   						Image img3 = img2.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
   						img = new ImageIcon(img3);
   						buttons[i][j].setIcon(img);
   					}
   					else if (c1.board.getBoardElement(i, j).getTeam() == Team.RED) { 
   						imageurl = cldr.getResource(c1.board.getBoardElement(i, j).toString() + ".png");
   						ImageIcon img = new ImageIcon(imageurl);
   						Image img2 = img.getImage();
   						Image img3 = img2.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
   						img = new ImageIcon(img3);
   						buttons[i][j].setIcon(img);
   					}
   				}
   				else if (c1.getRound()%2 == 1) {
   					if (c1.board.getBoardElement(i, j).getTeam() == Team.RED) {
   						imageurl = cldr.getResource("redHidden.png");
   						ImageIcon img = new ImageIcon(imageurl);
   						Image img2 = img.getImage();
   						Image img3 = img2.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
   						img = new ImageIcon(img3);
   						buttons[i][j].setIcon(img);
   					}
   					else if (c1.board.getBoardElement(i, j).getTeam() == Team.BLUE) { 
   						imageurl = cldr.getResource(c1.board.getBoardElement(i, j).toString() + ".png");
   						ImageIcon img = new ImageIcon(imageurl);
   						Image img2 = img.getImage();
   						Image img3 = img2.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
   						img = new ImageIcon(img3);
   						buttons[i][j].setIcon(img);
   					}
   				}
    		}
    	}
    }

    
    private class CardListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			try {
				ExtendedButton but = ((ExtendedButton) e.getSource());
				if ((but == buttons[3][2]) || (but == buttons[3][3]) || (but ==	buttons[3][6]) || (but == buttons[3][7]) || (but ==	buttons[4][2]) || (but == buttons[4][3]) || (but == buttons[4][6]) || (but == buttons[4][7]))
					return;
				if (c1.getRound()%2==1 && !cardSelected) {
					if (c1.board.getBoardElement(but.getI(), but.getJ()).getTeam() == Team.RED)
						return;
				}
				if (c1.getRound()%2==0 && !cardSelected) {
					if (c1.board.getBoardElement(but.getI(), but.getJ()).getTeam() == Team.BLUE)
						return;
				}
				if (cardSelected && !but.equals(selectedButton)) {
					int ret = c1.PlayTurn(selectedButton, but);
					if (ret == 1) {
						but.setIcon(selectedButton.getIcon());
						but.setName(selectedButton.getName());
						selectedButton.setIcon(null);
						selectedButton.setName(null);
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
					else if (ret == 2) {
						but.setIcon(selectedButton.getIcon());
						but.setName(selectedButton.getName());
						selectedButton.setIcon(null);
						selectedButton.setName(null);
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
					else if (ret == 3) {
						selectedButton.setIcon(null);
						selectedButton.setName(null);
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
					else if (ret == 4) {
						but.setIcon(null);
						but.setName(null);
						but.setBorder(UIManager.getBorder("Button.border"));
						selectedButton.setIcon(null);
						selectedButton.setName(null);
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
					else if (ret == 5) {
						but.setIcon(null);
						but.setName(null);
						but.setBorder(UIManager.getBorder("Button.border"));
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
					else if (ret == 6) {
						but.setBorder(UIManager.getBorder("Button.border"));
						selectedButton.setBorder(UIManager.getBorder("Button.border"));
						selectedButton=but;
						cardSelected=false;
						NextTurn();
					}
				}
				else if (cardSelected && but.equals(selectedButton)) {
					selectedButton.setBorder(UIManager.getBorder("Button.border"));
					cardSelected=false;
				}
				else if(!cardSelected && but.getName()!=null){
					selectedButton = but;
					selectedButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
					cardSelected = true;
				}
			}
			catch (NullPointerException ex) {
				System.out.println("Button is null");
			}
		}

		public void mouseEntered(MouseEvent arg0) {}

		public void mouseExited(MouseEvent arg0) {}

		public void mousePressed(MouseEvent arg0) {}

		public void mouseReleased(MouseEvent arg0) {}
    }
    
    
    public ExtendedButton getSelectedButton() {
    	return selectedButton;
    }
}
