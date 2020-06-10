package testProject;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

public class testGame extends JFrame {
	
	Connection connection;
	
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
	
	/**
	 * Start of the game.
	 */
	public static void main(String[] args) {
		testGame dbc = new testGame();
		
		dbc.connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Kristien\\Documents\\Ruben & Dietger\\Ruben\\Provil ION 6\\SQL\\sqlite-tools-win32-x86-3300100\\speldatabase.db");
		
		ResultSet result = dbc.executeStatement();
		
		Statement statement = connection.createStatement();
		statement.execute("insert into Player");
		
		ResultSet resultSet = statement.getResultSet();
		
		while (result.next()) {
			System.out.println(result.getString("Score"));
		}
		
		EventQueue.invokeLater(() -> {
			
			testGame testgame = new testGame();
			testgame.setVisible(true);
		});
	}
}
