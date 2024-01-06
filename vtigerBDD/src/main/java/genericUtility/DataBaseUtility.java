package genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility {
	
	public String fetchDataFromDatabase(Connection connection, String querry) throws SQLException {
		
		ResultSet result = connection.createStatement().executeQuery(querry);
		
		if(result.next()) {
			return result.getString(1);
		}
		
		return "";
	}
	
	public void insertDataToDatabase(Connection connection, String querry) throws SQLException {
		
		int result = connection.createStatement().executeUpdate(querry);
		
		if(result == 1) {
			System.out.println("Data Base is updated");
		}
		
		else
			System.out.println("Data Base is not updated");
	}

}
