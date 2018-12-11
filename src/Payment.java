
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Payment {

	private static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345"; //connecting details to database
	
	private Connection connection = null;
	private PreparedStatement updatesum = null; //setting up PreparedStatemenths
	
	public Payment()
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  //getting connection 
			updatesum = connection.prepareStatement("UPDATE bank SET sum = ? + sum WHERE cardNumber = ?"); // setting SET sql statementh to update database
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace(); //printing expextion or throwable and tells where it happened
		}
	}
	
	public void addsum (String sum, String cardNumber)  { //method to update data to database
		
		try
		{
		
		
		updatesum.setString(1, sum); //setting first String to sql function
		updatesum.setString(2, cardNumber); // setting second String to sql function
		int result = updatesum.executeUpdate(); //executing sql statementh
		
		
	}
	catch (SQLException sqlException) //expectino handling
	{
		sqlException.getErrorCode(); //getting error code
		sqlException.printStackTrace(); //printing expection or throwable and tells where it happened
	}
		
	
	}
	
}