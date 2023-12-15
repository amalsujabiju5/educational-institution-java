package webd4201sujaa;
/**
 * @author AMAL SUJA BIJU
 *
 */

import java.beans.Statement;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.sql.*;








@SuppressWarnings("unused")

public class StudentDA {

	
	static Vector<Student> students = new Vector<>(); // contains student
	// references
	
	static Student aStudent;
	
	// declaring the variable for the database connection
	static Connection aConnection;
	static java.sql.Statement aStatement;
	
	
	
	//declaring the static variable for all the student instance attributes values
	
	/**
	 * This variable is of type long to store the userid unique identification number
	 * 
	 * 
	 */
	private static long id;
	
	/**
	 * This variable is for to store the String Userid password
	 */
	private static String password;
	
	/**
	 * This variable is for to store the String firstName
	 */
	
	private static String firstName;
	
	/**
	 * This variable is for to store the String Userid lastname
	 */
	private static String lastName;
	
	/**
	 * This variable is for to store the String Userid emailAddress
	 */
	private static String emailAddress;
	
	/**
	 * This variable is for to store the last access of the user
	 */
	private static Date LastAccess;
	
	/**
	 * This variable is for to store the enroll date of the user
	 */
	private static Date enrolDate;
	
	/**
	 * This is to chek whether the user is enabled in the system
	 */
	
	private static boolean enabled;
	/**
	 * This variable is of type char to store the user�s type as a single character
	 */
	private static char type;
	/**
	 * Private Data variable that will store the program code for the Student object
	 */
	private static String programCode;
	/**
	 * Private Data variable that will store the program description for the Student object
	 */
	private static String programDescription;
	/**
	 * Private Data variable that will hold the year of the program they are currently enrolled in 1 for first year, 2 for second year, 3 for third year.
	 */
	private static int year;
	/**
	 * Private Vector of Mark objects named marks
	 */
	private static Vector<Mark> marks;

	private static Date lastAccess;
	
	
	//constants for the date format
	
	private static final SimpleDateFormat SQL_DF = new SimpleDateFormat(
			"yyyy-MM-dd");
	
	
	//initaialize the dataBase connection
	
	/**
	 * This method will create a statemernt that to be used in DB connection
	 * 
	 * 
	 *  @param c
	 *            A string that holds the DB connection
	 * 
	 */
	
	
	public static void initialize(Connection c){
		try{
			System.out.println("amal");
			aConnection = c;
			aStatement = aConnection.createStatement();
		}catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	/**
	 * This is to close the statement 
	 */
	public static void terminate(){
		try{//closing the statement
			 aStatement.close();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * This method gives if a record is already exist in the database
	 * 
	 * 
	 * 
	 * @param id compares the possible new user's ID to every other user's ID
	 * @return Student-specific data collection in object form
	 * @throws InvalidException 
	 * @throws  If the user cannot be located, NotFoundException returns an exception.
	 * 
	 * 
	 */
	public static Student retrieve(long id)throws NotFoundException, SQLException, InvalidNameException, InvalidNameException, InvalidPasswordException, InvalidUserDataException, InvalidException { // retrieve Customer and Boat data

		aStudent = new Student();
	        PreparedStatement sqlQuery = aConnection.prepareStatement("SELECT users.id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type, program_code, program_description, year FROM users, students WHERE users.id = students.id AND students.id = ?;");
	        sqlQuery.setLong(1, id);
	        try{
	        	
	        	ResultSet rs = sqlQuery.executeQuery();
	            boolean gotIt = rs.next();
	            if (gotIt)
	            	
	            	
	            {
	            	
	            	 id = rs.getLong("id");
	                 password = rs.getString("password");
	                 firstName = rs.getString("first_name");
	                 lastName =rs.getString("last_name");
	                 emailAddress =rs.getString("email_address");
	                 LastAccess = rs.getDate("last_access");
	                 enrolDate = rs.getDate("enrol_date");
	                 enabled =rs.getBoolean("enabled");
	                 type= 's';
	                 programCode =rs.getString("program_code");
	                 programDescription =rs.getString("program_description");
	                 year= rs.getInt("year");
	                 marks =new Vector<>();
	                 
	                 
	                 //validation and showing the error message
	                 try
	                 {
	                     aStudent = new Student(id, password, firstName, lastName, emailAddress, LastAccess, enrolDate, enabled, type, programCode, programDescription, year, marks);
	                 }
	                 catch (InvalidUserDataException e)
	                 {

	                     System.out.println("Record for "
	 							+ firstName
	 							+ " contains an invalid ID.  Verify and correct.");
	                 }
	            }
	            
	            else	// nothing was retrieved
	            {
	                throw (new NotFoundException("Problem retrieving Student record, ID " + id +" does not exist in the system."));
	            }
	            rs.close();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return aStudent;
    }
	
	 /**
     * @param aStudent      an object that contains student details
     * @return inserted     a boolean to tell if the insert passed/failed
     * @throws Exception 
     */
	
	public static boolean create(Student aStudent) throws Exception {
		boolean inserted = false;
		id =aStudent.getId();
//		password = aStudent.getPassword();
//		firstName = aStudent.getFirstName();
//        lastName = aStudent.getLastName();
//        emailAddress = aStudent.getEmailAddress();
//        LastAccess = aStudent.getLastAccess();
//        enrolDate = aStudent.getEnrolDate();
//        enabled = aStudent.isEnabled();
//        type = aStudent.getType();
        programCode = aStudent.getProgramCode();
        programDescription = aStudent.getProgramDescription();
        year = aStudent.getYear();
        marks = aStudent.getMarks();
        java.sql.Date lastAccessDate = new java.sql.Date(LastAccess.getTime());
        java.sql.Date ogEnrolDate = new java.sql.Date(enrolDate.getTime());
        //String hashword =aStudent.encryptPassword(password)
        @SuppressWarnings("static-access")
		String hashedPassword = aStudent.encryptPassword(password);
        // created SQL insert statement 
        // Prepared statement for the users table
       // String sqlUserQuery = "INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        //PreparedStatement sqlInsertUser = aConnection.prepareStatement(sqlUserQuery);
                
        // Prepared statement for the student table
        String sqlStudentQuery = "INSERT INTO students (id, program_code, program_description, year) VALUES (?, ?, ?, ?);";
        PreparedStatement sqlInsertStudent = aConnection.prepareStatement(sqlStudentQuery);
//        
//        sqlInsertUser.setLong(1, id);
//        sqlInsertUser.setString(2, hashedPassword);
//        sqlInsertUser.setString(3, firstName);
//        sqlInsertUser.setString(4, lastName);
//        sqlInsertUser.setString(5, emailAddress);
//        sqlInsertUser.setDate(6, lastAccessDate);
//        sqlInsertUser.setDate(7, ogEnrolDate);
//        sqlInsertUser.setBoolean(8, enabled);
//        sqlInsertUser.setString(9, String.valueOf(type));
        sqlInsertStudent.setLong(1, id);
        sqlInsertStudent.setString(2, programCode);
        sqlInsertStudent.setString(3, programDescription);
        sqlInsertStudent.setInt(4, year);
        

        
        try
        {
        	retrieve(id);
        	  throw (new DuplicateException("Problem with creating Student record, the Student ID: " + id +"; already exists in the system."));
        	}
        catch(DuplicateException | NotFoundException | SQLException e)
        {
            try
            {  
                //int rs = sqlInsertUser.executeUpdate();
                int rs1 = sqlInsertStudent.executeUpdate();
                if (rs1 >  0)
                {
                    inserted = true;
                }
               
            }
            catch (SQLException ee)
            { System.out.println(ee.getMessage());	}
        }
        return inserted;
    }

	

/**
 * A static method that named update() that accept a student arguement, return an integer
 * @param aStudent      object that contains data
 * @return records      number of records updated
 * @throws NotFoundException    throws an exception if the user cannot be found
 */

	public static int update(Student aStudent) throws NotFoundException, InvalidException, InvalidNameException, InvalidPasswordException, InvalidUserDataException, SQLException {
        int records = 0;  //records updated
	 
	 
	 id= aStudent.getId();
//	 password =aStudent.getPassword();
//	 firstName = aStudent.getFirstName();
//	 lastName = aStudent.getLastName();
//     emailAddress = aStudent.getEmailAddress();
//     LastAccess = aStudent.getLastAccess();
//     enrolDate = aStudent.getEnrolDate();
//     enabled = aStudent.isEnabled();
//     type = aStudent.getType();
     programCode = aStudent.getProgramCode();
     programDescription = aStudent.getProgramDescription();
     year = aStudent.getYear();
     marks = aStudent.getMarks();
     java.sql.Date lastAccessDate = new java.sql.Date(LastAccess.getTime());
     java.sql.Date ogEnrolDate = new java.sql.Date(enrolDate.getTime());
     
//     String sqlUpdateUser = "UPDATE users " +
//             "SET first_name = ?, " +
//             "last_name = ?, " +
//             "email_address = ?, " +
//             "last_access = ?, " +
//             "enrol_date = ?, " +
//             "type = ?, " +
//             "enabled = ? " +
//             "WHERE id = ?";
//     PreparedStatement sqlUserUpdate = aConnection.prepareStatement(sqlUpdateUser);
//     sqlUserUpdate.setString(1, firstName);
//     sqlUserUpdate.setString(2, lastName);
//     sqlUserUpdate.setString(3, emailAddress);
//     sqlUserUpdate.setDate(4, lastAccessDate);
//     sqlUserUpdate.setDate(5, ogEnrolDate);
//     sqlUserUpdate.setString(6, String.valueOf(type));
//     sqlUserUpdate.setBoolean(7, enabled);
//     sqlUserUpdate.setLong(8, id);
     String sqlUpdateStudent = "UPDATE students " +
             "SET program_code = ?, " +
             "program_description = ?, " +
             "year = ? " +
             "WHERE id = ?";
     PreparedStatement sqlStudentUpdate = aConnection.prepareStatement(sqlUpdateStudent);
     sqlStudentUpdate.setString(1, programCode);
     sqlStudentUpdate.setString(2, programDescription);
     sqlStudentUpdate.setInt(3, year);
     sqlStudentUpdate.setLong(4, id);

     try
     {
         retrieve(id);  
         //records = sqlUserUpdate.executeUpdate();
         records = sqlStudentUpdate.executeUpdate();
     }catch(NotFoundException e)
     {
         throw new NotFoundException("Student with id " + id
                 + " cannot be updated, does not exist in the system.");
     }catch (SQLException e)
     { System.out.println(e.getMessage());}
     return records;
 }

/**
 * A static method to delet that accept the student argument
 */

public static int delete(Student aStudent)throws  NotFoundException, InvalidException, InvalidNameException, InvalidPasswordException, InvalidUserDataException, SQLException {
	int records =0;
	  id = aStudent.getId();
      String sqlDeleteStudent = "DELETE FROM students WHERE id = ?;";
     // String sqlDeleteUser = "DELETE FROM users WHERE id = ?;";
     // PreparedStatement sqlUserDelete = aConnection.prepareStatement(sqlDeleteUser);
      PreparedStatement sqlStudentDelete = aConnection.prepareStatement(sqlDeleteStudent);
     // sqlUserDelete.setLong(1, id);
      sqlStudentDelete.setLong(1, id);
      try
      {
    	  retrieve(id);  
    	  records = sqlStudentDelete.executeUpdate();
    	  records = sqlStudentDelete.executeUpdate();
      }catch(NotFoundException e)
      {
          throw new NotFoundException("Student with id " + id
                  + " cannot be deleted, does not exist.");
      }catch (SQLException e)
      { System.out.println(e.getMessage());	}
      return records;
  }
  
      

/**
 * Authenticate- this method should return a student object and this will throw an not found exception if the credeentials doesnot match
 *@param studentNum   student number entered as long
 *@param password     student password entered as long
 *@return astudent
 *@throws NotFoundException throws an exception if the user cannot be found
 *
 *
 */
/**
 * 
 * This method accepts a long student number and a string password, it will
 * return a Student object if it exists in the database. Throws a NotFound
 * Exception if the student's ID and password combination are not found.
 * Also throws InvalidIdException, InvalidUserDataException and SQLException.
 * 

 * @return if the student exists in the database or not
 * @throws NotFoundException if the student was not found in the database
 * @throws If the student ID was not discovered in the database, an InvalidIdException will occur.
 * @throws If the data sent is invalid, throw the InvalidUserDataException
 * @throws If any common SQL problems are found, SQLException will be thrown
 */
public static Student authenticate(long possibleId, String aPassword) 
        throws NotFoundException, InvalidException, InvalidUserDataException, SQLException {
    
    aStudent = null;
    
    String sqlQuery = "SELECT u.id, u.password, u.firstName, u.lastName, "
            + "u.emailAddress, u.lastAccess, u.enrolDate, u.enabled,  "
            + "u.type, s.programCode, s.programDesc, s.year FROM users u, "
            + "students s WHERE  u.id = s.id AND u.id = ? AND "
            + "u.password = ?";
    //System.out
    PreparedStatement AUTHENTICATE_STMT = aConnection.prepareStatement(sqlQuery
                    );   
    AUTHENTICATE_STMT.setLong(1, possibleId);
    AUTHENTICATE_STMT.setString(2, aPassword);
    
    try {
        ResultSet rs = AUTHENTICATE_STMT.executeQuery();           
        
        if(rs.next()) {
            id = rs.getLong("id");
            password = rs.getString("password");
        firstName = rs.getString("first_name");
            lastName = rs.getString("last_Name");
            emailAddress = rs.getString("email_Address");
            LastAccess = rs.getDate("last_access");
            enrolDate = rs.getDate("enrol_date");
            type = rs.getString("type").charAt(0);
            enabled = rs.getBoolean("enabled");
            programCode = rs.getString("programCode");
            programDescription = rs.getString("programDesc");
            year = rs.getInt("year");        
            
            aStudent = new Student(id, password, firstName, 
                                lastName, emailAddress, lastAccess, 
                                enrolDate, enabled, type, programCode, 
                                programDescription, year);
            
        } else {
            throw (new NotFoundException("The ID and password cannot"
                    + " be found in the database."));
        }
        
        rs.close();
        
    } catch(SQLException|NotFoundException e) {
        System.out.println(e);
    }
    
    return aStudent;

}

public static String encryptPassword(String password2) {
	// TODO Auto-generated method stub
	return null;
}




/**
 * Validates password similar to the method above
 * @param aPassword
 * @return
 * @throws NotFoundException
 * @throws InvalidIdException
 * @throws InvalidUserDataException
 * @throws SQLException
 */
public static Student authenticate_password(String aPassword)
	
	throws NotFoundException, InvalidException, InvalidUserDataException, SQLException {
	
	
	aStudent = null;
	
	
	
	String sqlQuery ="SELECT id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, "
	
	+ "type, program_code, program_description, year FROM users JOIN students USING (id) WHERE password = '?'";
	
	
	
	PreparedStatement AUTHENTICATE_DB = aConnection.prepareStatement(sqlQuery );
	
	
	AUTHENTICATE_DB.setString(1, aPassword);
		
	
		try {
		
		ResultSet rs = AUTHENTICATE_DB.executeQuery();
		
		
		
		if(rs.next()) {
		
		id = rs.getLong("id");
		
		password = rs.getString("password");
		
		firstName = rs.getString("firstName");
		
		lastName = rs.getString("lastName");
		
		emailAddress = rs.getString("emailAddress");
		
		lastAccess = rs.getDate("lastAccess");
		
		enrolDate = rs.getDate("enrolDate");
		
		type = rs.getString("type").charAt(0);
		
		enabled = rs.getBoolean("enabled");
		
		programCode = rs.getString("programCode");
		
		programDescription = rs.getString("programDesc");
		
		year = rs.getInt("year");
		
		
		
		 aStudent = new Student(id, password, firstName, 
                 lastName, emailAddress, lastAccess, 
                 enrolDate, enabled, type, programCode, 
                 programDescription, year);

		
		
		} else {
		
		throw (new NotFoundException("The password cannot"
		
		+ " be found in the database."));
		
		}
		
		
	
		rs.close();
		
		
		
		} catch(SQLException e) {
		
		System.out.println(e);
		
		}
		
		
		
		return aStudent;
		
		}
}	 
			 
	 


	 
	 
	 
	 


	
	
	    
	

