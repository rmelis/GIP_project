package testProject;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class testGame extends JFrame {
	public testGame() {
		startGame();
	}
	
	/**
	 * Create the board.
	 */
	private void startGame() {
		add(new testBoard());
		
		setTitle("testGame");
		setSize(1000, 1000);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			testGame Game = new testGame();
			Game.setVisible(true);
    	});
	}
}