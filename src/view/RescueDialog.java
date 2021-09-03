package view;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Piece;

public class RescueDialog {
	
	String s;
	int numOfChoice;
	private URL imageURL;
	public ClassLoader cldr = this.getClass().getClassLoader();
	
	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a new Rescue Dialog Window</p>
	 */
	public RescueDialog(ArrayList<Piece> lostPieces) {
		JFrame rescueFrame = new JFrame();
		String[] pieces = new String[lostPieces.size()];
		int[] piecesNumber = new int[lostPieces.size()];
		int j=-1;
		for (int i=0; i<lostPieces.size(); i++) {
			if (lostPieces.get(i) != null) {
				j++;
				Piece piece = (Piece) lostPieces.get(i);
				pieces[j] = piece.toString();
				piecesNumber[j] = i;
			}
		}
		imageURL = cldr.getResource("stratego_small.jpg");
		ImageIcon img = new ImageIcon(imageURL);
		Image img2 = img.getImage();
		Image img3 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		img = new ImageIcon(img3);
		s = (String)JOptionPane.showInputDialog(rescueFrame, "Select a Piece:\n", "Rescue", JOptionPane.PLAIN_MESSAGE, img, pieces, "");
		if (s != null) {
			for (int i=0; i<pieces.length; i++) {
				if (pieces[i].equals(s)) {
					numOfChoice = i;
					i = pieces.length + 1;
				}
			}
    	}
	}
	
	/**
	 * <b><p>Accessor(Selector)</p></b>
	 * <p>Postconditions: returns the choice of the player<p>
	 * @return the choice of the player
	 */
	public int choice() {
		if (s == null)
			return -1;
		else
			return numOfChoice;
	}

}
