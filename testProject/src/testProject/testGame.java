package testProject;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class testGame extends JFrame {
	public testGame() {
		startGame();
	}
	
//	The function "startGame()" is made.
	private void startGame() {
//		A new board is made: on this board, everything will happen.
		add(new testBoard());
		
//		Here we set the title and the size of the board.
		setTitle("testGame");
		setSize(1000, 1000);
		
//		Here we set the default operation when closing this window.
//		The size of the window cannot be changed, and it will show up in the middle of the screen.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
//	Here we will start a new game, and make it visible on screen.
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			
			testGame testgame = new testGame();
			testgame.setVisible(true);
		});
	}
}
