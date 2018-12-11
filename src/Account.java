import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Account {
	
	private static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345"; //connecting details to database

	
	private PreparedStatement insertcard = null; //setting up PreparedStatemenths
	private PreparedStatement searchsum = null; 
	private PreparedStatement deletecard = null;
	private Connection connection = null;
	
	
	public Account()
	
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  //getting connection 
			insertcard = connection.prepareStatement("INSERT INTO bank (cardNumber) VALUES (?)"); //setting sql statementh to INSERT INTO
			searchsum = connection.prepareStatement("SELECT sum FROM bank WHERE cardNumber = ?"); // setting sql statementnt to SELECT
			deletecard = connection.prepareStatement("DELETE FROM bank WHERE cardNumber = ?"); //setting up sql statementh to DELETE
			
		}
		catch (SQLException sqlException) //Expection handling
		{
			sqlException.printStackTrace(); //printing expection or throwable and tells where it happened
		}
	}
	
	public void addcard (String cardNumber )  { //method to adding data to database
		try
		{
		
		insertcard.setNString(1, cardNumber); // setting variable to sql statementh
		int result = insertcard.executeUpdate();  //executing  sql statementh
	}
	catch (SQLException sqlException) //Expection handling
	{
		sqlException.printStackTrace(); //printing expection or throwable and tells where it happened
	}	
	
	}
	

public  String getbalance (String cardNumber )  { // method to read data from database
	
	try
	{
	
	
	searchsum.setNString(1, cardNumber); //setting variable to sql statementh
	 ResultSet result = searchsum.executeQuery(); //executing sql statementh
	
	while (result.next()) {  //moving "cursor" so i can get correct value
		 
		JOptionPane.showInputDialog("total sum of money at your card is:" + result.getString(1)); //getting correct result from sql statementh and printing it as showinputdialog
	    
		
		}
	
	
}
catch (SQLException sqlException) //Expection handling
{			
	sqlException.printStackTrace(); //printing expection or throwable and tells where it happened
}
	return cardNumber;
	
	}


public  void removecard (String cardNumber )  { //method to remove data from database
	
	try
	{
	
	
	deletecard.setNString(1, cardNumber); //setting variable to sql statementh
	int result = deletecard.executeUpdate(); //executing sql statementh
}
catch (SQLException sqlException) //Expection handling
{
	sqlException.printStackTrace(); //printing expection or throwable and tells where it happened
}	

}

}







	
	
	

	
	
	
	
		
