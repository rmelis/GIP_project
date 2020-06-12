package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {
	Connection connection;
	
	public testConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/testProject/speldatabase.db");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error connecting to database");
		}
	}
	
	public void insertPlayerName(String name) {
		try {
			Statement statement = connection.prepareStatement("INSERT INTO Player(PlayerName) VALUES(" + name + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertScore(int score) {
		try {
			Statement statement = connection.prepareStatement("INSERT INTO Score(Score) VALUES(" + score + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
