package dataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(null, null, null);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("");
	}

}
