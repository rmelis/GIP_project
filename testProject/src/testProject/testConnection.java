package testProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public void insertScore(String playername, int score) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("INSERT INTO Score(PlayerName, Score) VALUES(? ,?)");
			ps.setString(1,  playername);
			ps.setInt(2,  score);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> retrieveScoresFromDB(){
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM Score");
			ps.execute();
			ResultSet resultset = ps.getResultSet();
			List<String> resultlist = new ArrayList<String>();
			while (resultset.next()) {
				resultlist.add("Player: " + resultset.getString("PlayerName") +", Score: " + resultset.getString("Score"));
			}
			return resultlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
