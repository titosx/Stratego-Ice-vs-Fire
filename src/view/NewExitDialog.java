package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NewExitDialog {
	
	private int choice = -2;	

	/**
	 * <b><p>Constructor</p></b>
	 * <p>Postconditions: creates a NewExitDialog window</p>
	 */
	public NewExitDialog(String str) {
		JFrame window = new JFrame();
		if (str.equals("Player1")) {
			int ret = JOptionPane.showConfirmDialog(null, "Player 1 won! Do you want to play a new game?", "Stratego", JOptionPane.YES_NO_OPTION);
			if (ret == 1)
				choice = 0;
			else
				choice = 1;
		}
		else if (str.equals("Player2")) {
			int ret = JOptionPane.showConfirmDialog(null, "Player 2 won! Do you want to play a new game?", "Stratego", JOptionPane.YES_NO_OPTION);
			if (ret == 1)
				choice = 0;
			else
				choice = 1;
		}
	}

	/**
	 * <b><p>Accessor (Selector)</p></b>
	 * <p>Postcondition: return the user's choice</p>
	 * @return the user's choice
	 */
	public int choice() {
		return choice;
	}
}