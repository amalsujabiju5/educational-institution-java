package webd4201sujaa;

/**
 * @author amal suja biju
 */

import java.sql.*;

public class DatabaseConnect {
	/**
	 * Location of database
	 */
	static String url = "jdbc:postgresql://127.0.0.1:5432/webd4201_db";
	/**
	 * Connection object 
	 */
	static Connection aConnection;
	/**
	 * Database user admin
	 */
	static String user = "webd4201_admin";
	/**
	 * Database user password
	 */
	static String password = "webd4201_password";
	
	/**
	 * Initializing the database connection
	 */
	public static Connection initialize()
	{
		//Using try catch method
		try
 		{ 	
			Class.forName("org.postgresql.Driver"); // It will load the driver for PostGreSQL
			aConnection = DriverManager.getConnection(url, user, password); //  Instance connection of database
			System.out.println("clint2" );
	 	}
		catch (ClassNotFoundException e)  //will throw an exception 
		{
			System.out.println("clint1" + e);
		}
		catch (SQLException e)	//This will catch any other exceptions
			{ System.out.println("clint" + e); }
		return aConnection;
	}

	/**
	 * Closing the database connection
	 */
	public static void terminate()
	{
		try
 		{
    		aConnection.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}


}
